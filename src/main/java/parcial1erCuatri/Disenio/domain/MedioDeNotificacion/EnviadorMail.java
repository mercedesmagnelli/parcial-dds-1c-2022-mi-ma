package parcial1erCuatri.Disenio.domain.MedioDeNotificacion;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EnviadorMail implements MedioDeComunicacion {

    private JavaMailSender sender;

    public void notificar() {
        this.sendEmail("mechamagnelli@gmail.com","prueba", "hola, soy un mail");
    }
    public void sendEmail(String to, String subject, String content) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

        sender.send(email);
    }
}
