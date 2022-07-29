package parcial1erCuatri.Disenio;

import org.junit.jupiter.api.Test;
import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;
import parcial1erCuatri.Disenio.domain.Venta.Producto;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemCompraTest {
  @Test
  public void calcularElTotalDeUnItem() throws StockInsuficienteException {
    Producto producto1= new Producto("Bebida" , "Coca cola", 100.0, 5);
    ItemVenta itemDeCompra1 = new ItemVenta(producto1,2,false);
    assertEquals(itemDeCompra1.calcularPrecioItem(),200.0);
  }

  @Test
  public void calcularElTotalDeUnItemQueNoTieneStock() throws StockInsuficienteException{
    Producto producto1= new Producto("Bebida" , "Coca cola", 100.0, 1);
    assertThrows(StockInsuficienteException.class, ()-> {new ItemVenta(producto1,2,false);});
  }
}
