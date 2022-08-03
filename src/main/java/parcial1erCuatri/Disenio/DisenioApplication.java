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
/*
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

		Administrador administrador = new Administrador();
		administrador.agregarProductoAlStock(producto1);
		administrador.agregarProductoAlStock(producto2);
		//	carritoDeCompra.finalizarVenta(MedioDePago.EFECTIVO);
*/
		Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);

	}

}
