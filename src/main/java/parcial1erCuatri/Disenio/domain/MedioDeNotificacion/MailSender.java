package parcial1erCuatri.Disenio.domain.MedioDeNotificacion;

import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;
import parcial1erCuatri.Disenio.domain.Venta.Venta;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {

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


    public void enviarDetalleDeCompra(String mail, Venta v, Boolean pagaEnDolares) {
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

           System.out.print(cuerpo);
        }

        String moneda = "$";

        if(v.getHechaEnDolares()) {
            moneda = "U$D";
        }

        cuerpo = cuerpo + "\n TOTAL DE LA COMPRA SIN DESCUENTOS: " + moneda + v.getPrecioTotalSinDescuento() +
        "\n TOTAL DE LA COMPRA CON DESCUENTOS: " + moneda + v.getPrecioTotalConDescuento() + "\n";
        System.out.print(cuerpo);
        return cuerpo;
    }
}
