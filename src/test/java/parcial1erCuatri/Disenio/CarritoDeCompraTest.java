package parcial1erCuatri.Disenio;

import org.junit.jupiter.api.Test;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.Roles.TipoDeDocumento;
import parcial1erCuatri.Disenio.domain.Venta.*;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoDeCompraTest {
  @Test
  public void CalcularPrecioSinPromocion() throws StockInsuficienteException {
    Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5);
    ItemVenta itemDeCompra1 = new ItemVenta(producto1,2);
    Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);
    ItemVenta itemDeCompra2 = new ItemVenta(producto2,4);
    Collection<ItemVenta> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
    Collection<Promocion> promociones = new ArrayList<>();
    Cliente cliente1=new Cliente("Lionel Andres","Messi","leomessi@gmail.com","48662200",LocalDate.now(), TipoDeDocumento.DNI,"40976081");
    CarritoDeCompras carritoDeCompra = new CarritoDeCompras(promociones, LocalDate.now(), MedioDePago.EFECTIVO,cliente1,false);
    carritoDeCompra.setItemsCompras(itemsCompras);
    assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),500.0);
  }

  @Test
  public void CalcularPrecioConUnaPromocionDeMedioDePago() throws StockInsuficienteException {
    Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5);
    ItemVenta itemDeCompra1 = new ItemVenta(producto1,2);
    Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);
    ItemVenta itemDeCompra2 = new ItemVenta(producto2,4);
    Collection<ItemVenta> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
    PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
    Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
    Cliente cliente1=new Cliente("Lionel Andres","Messi","leomessi@gmail.com","48662200",LocalDate.now(), TipoDeDocumento.DNI,"40976081");
    CarritoDeCompras carritoDeCompra = new CarritoDeCompras(promociones, LocalDate.now(), MedioDePago.EFECTIVO,cliente1,false);
    carritoDeCompra.setItemsCompras(itemsCompras);
    assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),450.0);
  }

  @Test
  public void CalcularPrecioConUnaPromocionDeMedioDePagoEnDolares() throws StockInsuficienteException {
    Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5);
    ItemVenta itemDeCompra1 = new ItemVenta(producto1,2);
    Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);
    ItemVenta itemDeCompra2 = new ItemVenta(producto2,4);
    Collection<ItemVenta> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
    PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.10);
    Collection<Promocion> promociones = Arrays.asList(promoMedioDePago);
    Cliente cliente1=new Cliente("Lionel Andres","Messi","leomessi@gmail.com","48662200",LocalDate.now(), TipoDeDocumento.DNI,"40976081");
    CarritoDeCompras carritoDeCompra = new CarritoDeCompras(promociones, LocalDate.now(), MedioDePago.EFECTIVO,cliente1,true);
    carritoDeCompra.setItemsCompras(itemsCompras);
    assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),59211.00000000001);
  }
  @Test
  public void CalcularPrecioSinPromocionesEnDolares() throws StockInsuficienteException {
    Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5);
    ItemVenta itemDeCompra1 = new ItemVenta(producto1,2);
    Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);
    ItemVenta itemDeCompra2 = new ItemVenta(producto2,4);
    Collection<ItemVenta> itemsCompras = Arrays.asList(itemDeCompra1,itemDeCompra2);
    Collection<Promocion> promociones = new ArrayList<>();
    Cliente cliente1=new Cliente("Lionel Andres","Messi","leomessi@gmail.com","48662200",LocalDate.now(), TipoDeDocumento.DNI,"40976081");
    CarritoDeCompras carritoDeCompra = new CarritoDeCompras(promociones, LocalDate.now(), MedioDePago.EFECTIVO,cliente1,true);
    carritoDeCompra.setItemsCompras(itemsCompras);
    assertEquals(carritoDeCompra.calcularPrecioTotalConPromociones(),65790.0);
  }

}
