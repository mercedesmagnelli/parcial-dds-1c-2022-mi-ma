package parcial1erCuatri.Disenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import parcial1erCuatri.Disenio.domain.Repositorios.*;
import parcial1erCuatri.Disenio.domain.Roles.Administrador;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.Roles.TipoDeDocumento;
import parcial1erCuatri.Disenio.domain.Venta.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
  @Autowired
  private RepoProductos repoProductos;
  @Autowired
  private RepoPromociones repoPromociones;
  @Autowired
  private RepoRoles repoUsuarios;
  @Autowired
  private RepoCarritos repoCarritos;
  @Autowired
  private RepoItemVentas repoItemVentas;
  @Autowired
  private Registro registro;

  @Override
  public void run(String... args) throws Exception {
    if (repoProductos.count() == 0) {
      Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5);
      Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);
      Producto lemonPie= new Producto("Porcion grande" , "Lemon Pie", 150.0, 5);
      Producto chocotorta= new Producto("Porcion mediana" , "Chocotorta", 250.0, 5);
      Producto tortaOreo= new Producto("Porcion pequeña" , "Torta Oreo", 350.0, 5);

      List<Producto> productosIniciales = new ArrayList<>();
      productosIniciales.add(producto1);
      productosIniciales.add(lemonPie);
      productosIniciales.add(chocotorta);
      productosIniciales.add(tortaOreo);

      productosIniciales.stream().forEach(producto -> {
        repoProductos.save(producto);
      });

   //   ItemVenta itemDeCompra2 = new ItemVenta(producto2,4, false);
      Administrador administrador1 = new Administrador("jorge", "castro", "jorgecastro@gmail.com", TipoDeDocumento.DNI,"23789877" ,"47750077");
      administrador1.setRepoProductos(repoProductos);
      administrador1.setRepoPromociones(repoPromociones);

      repoUsuarios.save(administrador1);
      administrador1.agregarProductoAlStock(producto2);

      PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.05);
      administrador1.cargarPromocion(promoMedioDePago);

      PromoMedioDePago promoMedioDePagoDebito = new PromoMedioDePago(MedioDePago.TARJETA_DEBITO,0.02);
      repoPromociones.save(promoMedioDePagoDebito);

      administrador1.eliminarPromocion(promoMedioDePagoDebito);
      administrador1.eliminarProductoDeStock(producto2);

      //Creación Cliente
      Cliente cliente1=new Cliente("Lionel Andres","Messi","leomessi@gmail.com","48662200", TipoDeDocumento.DNI,"40976081",false);
      repoUsuarios.save(cliente1);
      CarritoDeCompras carritoDeCompra1 = new CarritoDeCompras(Arrays.asList(promoMedioDePago), LocalDate.now(), MedioDePago.EFECTIVO,cliente1,false);
      ItemVenta itemDeVenta1 = new ItemVenta(producto1,2, false);
      //ItemVenta itemDeVenta2 = new ItemVenta(producto2,4, false);
      repoItemVentas.save(itemDeVenta1);
      ArrayList<ItemVenta> listaItem = new ArrayList<>();
      listaItem.add(itemDeVenta1);
      carritoDeCompra1.setItemsVentas(listaItem);
      //registro.registrarItemCarrito(carritoDeCompra1,itemDeVenta1);
      registro.finalizarVenta(carritoDeCompra1);
      repoItemVentas.save(itemDeVenta1);
    }
  }
}
