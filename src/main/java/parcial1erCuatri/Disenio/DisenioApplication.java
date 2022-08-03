package parcial1erCuatri.Disenio;

import net.bytebuddy.asm.Advice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parcial1erCuatri.Disenio.domain.MedioDeNotificacion.MailSender;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.Roles.TipoDeDocumento;
import parcial1erCuatri.Disenio.domain.Venta.*;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class DisenioApplication {

	public static void main(String[] args) throws StockInsuficienteException {
		SpringApplication.run(DisenioApplication.class, args);

		Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5);
		ItemVenta itemDeCompra1 = new ItemVenta(producto1,2, false);

		Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);
		ItemVenta itemDeCompra2 = new ItemVenta(producto2,4, false);

		ArrayList<ItemVenta> itemsCompras = new ArrayList<>();
		itemsCompras.add(itemDeCompra1);
		itemsCompras.add(itemDeCompra2);

		PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.05);

		Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
		Cliente cliente1 = new Cliente("Lionel Andres","Messi","mechamagnelli@gmail.com","48662200", TipoDeDocumento.DNI,"40976081",true);

		CarritoDeCompras carritoDeCompra = new CarritoDeCompras(promociones, LocalDate.now(), MedioDePago.EFECTIVO,cliente1,true);
		carritoDeCompra.setItemsCompras(itemsCompras);

		//	carritoDeCompra.finalizarVenta(MedioDePago.EFECTIVO);

	}

}
