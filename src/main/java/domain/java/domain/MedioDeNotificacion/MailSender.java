package domain.java.domain.MedioDeNotificacion;

import domain.java.domain.MedioDeNotificacion.MedioDeComunicacion;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



public class MailSender implements MedioDeComunicacion {


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
