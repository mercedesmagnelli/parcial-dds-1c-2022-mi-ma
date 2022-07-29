package parcial1erCuatri.Disenio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parcial1erCuatri.Disenio.domain.MedioDeNotificacion.MailSender;

@SpringBootApplication
public class DisenioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisenioApplication.class, args);
		MailSender.getInstance().notificar();
	}

}
