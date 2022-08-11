package parcial1erCuatri.Disenio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoProductos;
import parcial1erCuatri.Disenio.domain.Roles.Administrador;
import parcial1erCuatri.Disenio.domain.Venta.*;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

@SpringBootApplication
public class DisenioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisenioApplication.class, args);

	}

}
