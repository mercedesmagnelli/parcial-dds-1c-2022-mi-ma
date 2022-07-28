package domain.java.parcial1erCuatri.Disenio;

import domain.java.domain.MedioDeNotificacion.MailSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class DisenioApplication {

	public static void main(String[] args){
		SpringApplication.run(DisenioApplication.class, args);

		MailSender ms = new MailSender();
		ms.notificar();

	}
}
