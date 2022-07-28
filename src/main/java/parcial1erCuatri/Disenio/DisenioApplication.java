package parcial1erCuatri.Disenio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parcial1erCuatri.Disenio.domain.MedioDeNotificacion.EnviadorMail;


import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class DisenioApplication {

	public static void main(String[] args){
		SpringApplication.run(DisenioApplication.class, args);

		EnviadorMail ms = new EnviadorMail();
		ms.notificar();

	}
}
