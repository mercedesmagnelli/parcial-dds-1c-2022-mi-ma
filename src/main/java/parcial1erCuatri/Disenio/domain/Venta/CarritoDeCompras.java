package parcial1erCuatri.Disenio.domain.Venta;

import parcial1erCuatri.Disenio.domain.Cotizador.CotizadorDolar;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Entity
public class CarritoDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    @JoinColumn(name = "carritoDeCompras_id")
    @OrderColumn(name = "posicion")
    private List<ItemVenta> itemsVentas = new ArrayList<>();

    @ManyToMany
    private Collection<Promocion> promociones = new ArrayList<>();

    private LocalDate fechaDeVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "medioDePago")
    private MedioDePago medioDePago;

    @OneToOne
    private Cliente cliente;
    private boolean estaEnDolares;

    public CarritoDeCompras() {
        super();
    }

    public CarritoDeCompras(Collection<Promocion> promociones, LocalDate fechaDeVenta, MedioDePago medioDePago, Cliente cliente,Boolean estaEnDolares) {
        this.itemsVentas = new ArrayList<>();
        this.promociones = promociones;
        this.fechaDeVenta = fechaDeVenta;
        this.medioDePago = medioDePago;
        this.cliente = cliente;
        this.estaEnDolares = estaEnDolares;
    }

    public void limpiarCarrito() {
        this.setItemsVentas(new ArrayList<>());
        this.setPromociones(new ArrayList<>());
        fechaDeVenta = null;
        medioDePago = null;

    }

    public Venta generarVenta() {
        double precioDesc = this.calcularPrecioTotalConPromociones();
        double precioSinDesc = this.calcularPrecioTotalSinPromociones();
        return new Venta(itemsVentas, LocalDate.now(), medioDePago, precioSinDesc, precioDesc, estaEnDolares);
    }

    public void agregarItemAlCarrito(ItemVenta item) {
        itemsVentas.add(item);
    }

    public List<ItemVenta> getItemsVentas() {
        return itemsVentas;
    }

    public void setItemsVentas(ArrayList<ItemVenta> itemsVentas) {
        this.itemsVentas = itemsVentas;
    }

    public Collection<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(Collection<Promocion> promociones) {
        this.promociones = promociones;
    }

    public LocalDate getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(LocalDate fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getEstaEnDolares() {
        return estaEnDolares;
    }

    public void setEstaEnDolares(Boolean estaEnDolares) {
        this.estaEnDolares = estaEnDolares;
    }

    public double calcularPrecio() {

        return itemsVentas.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
    }

    public double calcularPrecioTotalSinPromociones(){

        if(this.getEstaEnDolares()){
            CotizadorDolar cotizadorDolar = CotizadorDolar.getConfigurador();
            return this.calcularPrecio() / cotizadorDolar.getPrecioDolar();
        }else{
            return this.calcularPrecio();
        }
    }

    public double calcularPrecioTotalConPromociones(){
        if(this.getEstaEnDolares()){
            CotizadorDolar cotizadorDolar = CotizadorDolar.getConfigurador();
           return (this.calcularPrecio() - (promociones.stream().mapToDouble(x->x.aplicar(this)).sum())) / cotizadorDolar.getPrecioDolar();
        }else{
            return this.calcularPrecio() - promociones.stream().mapToDouble(x->x.aplicar(this)).sum();
        }
    }

    public void eliminarItemAlCarrito(ItemVenta itemVenta) {
        itemsVentas.remove(itemVenta);
    }

    public static class MailSender {

        private static MailSender INSTANCE = null;

        public static MailSender getInstance() {
            if(INSTANCE == null){
                INSTANCE = new MailSender();
            }
            return INSTANCE;
        }


        private static final String remitente = "mechamagnelli";
        // En una implementacion real esto no debería estar commiteado porque es re peligroso jajajaja
        private static final String password = "kjqphfukervxriiv";

        public void enviarConGMail(String destinatario, String asunto, String cuerpo) {

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", password);    //La clave de la cuenta
            props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
            props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            try {
                message.setFrom(new InternetAddress(remitente));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));   //Se podrían añadir varios de la misma manera
                message.setSubject(asunto);
                message.setText(cuerpo);
                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", remitente, password);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
            catch (MessagingException me) {
                me.printStackTrace();   //Si se produce un error
            }
        }


        public void enviarDetalleDeCompra(String mail, Venta v) {
            String cuerpo = this.generarCuerpo(v);
            this.enviarConGMail(mail, "Detalle de tu última compra en Cafe HumiTito", cuerpo);
        }

        private String generarCuerpo(Venta v) {

            String cuerpo = "Los detalles de tu compra en nuestro café es la siguiente \n \n";

            for(int i=0; i < v.getItemsVentas().size(); i ++){

                ItemVenta itemEnIndice = v.getItemsVentas().get(i);
                cuerpo = cuerpo + itemEnIndice.getProducto().getNombre() + "x"
                        + itemEnIndice.getCantidad() + " \n $" + itemEnIndice.getProducto().getPrecio() * itemEnIndice.getCantidad()
                        + "\n";


            }

            String moneda = "$";

            if(v.getHechaEnDolares()) {
                moneda = "U$D";
            }

            cuerpo = cuerpo + "\n TOTAL DE LA COMPRA SIN DESCUENTOS: " + moneda + v.getPrecioTotalSinDescuento() +
            "\n TOTAL DE LA COMPRA CON DESCUENTOS: " + moneda + v.getPrecioTotalConDescuento() + "\n";

            return cuerpo;
        }
    }
}


