package parcial1erCuatri.Disenio.domain.MedioDeNotificacion;

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


    public void notificar() {
        this.enviarConGMail("mechamagnelli@gmail.com", "Consulta sobre el equipo", "hola hermana queria consultarte mediante la presente si pudiste instalar todo xd");
    }
}
