package parcial1erCuatri.Disenio.domain.Venta;

import parcial1erCuatri.Disenio.domain.Cotizador.CotizadorDolar;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
}


