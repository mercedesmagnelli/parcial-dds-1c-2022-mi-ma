package parcial1erCuatri.Disenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import parcial1erCuatri.Disenio.domain.Repositorios.*;
import parcial1erCuatri.Disenio.domain.Roles.*;
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
  private RepoRoles repoRoles;
  @Autowired
  private RepoCarritos repoCarritos;
  @Autowired
  private RepoItemVentas repoItemVentas;
  @Autowired
  private RepoUsuarios repoUsuarios;
  @Autowired
  private Registro registro;


  @Override
  public void run(String... args) throws Exception {
    if (repoProductos.count() == 0) {

      //agregamos productos
      Producto producto1 = new Producto("Bebida" , "Coca cola", 150.0, 500);
      Producto producto2 = new Producto("Snacks" , "chetos", 50.0, 500);
      Producto lemonPie = new Producto("Porcion grande" , "Lemon Pie", 150.0, 500);
      Producto chocotorta = new Producto("Porcion mediana" , "Chocotorta", 250.0, 500);
      Producto tortaOreo = new Producto("Porcion pequeña" , "Torta Oreo", 350.0, 50);
      Producto chocolatada = new Producto("Bebida de chocolate x200 ml", "Chocolatada", 200.0, 100);
      Producto cafeConLeche = new Producto("Cafe con leche", "Cortado", 150.0, 600);
      Producto cookie = new Producto("Galletita con chispas de chocolate", "Cookie", 300.0, 350);




      List<Producto> productosIniciales = new ArrayList<>(Arrays.asList(producto1, producto2, lemonPie, chocotorta, tortaOreo, chocolatada, cafeConLeche, cookie));


      Administrador administrador1 = new Administrador("jorge", "castro", "jorgecastro@gmail.com", TipoDeDocumento.DNI,"23789877" ,"47750077");
      Cliente messi = new Cliente("Lionel Andres","Messi","leomessi@gmail.com","48662200", TipoDeDocumento.DNI,"40976081",false);
      Cliente jimHalpert = new Cliente("Jim", "Halpert", "jimhalpert@gmail.com", "12334565", TipoDeDocumento.DNI, "123456789", true);

      //agregamos roles

      List<Rol> roles = new ArrayList<>(Arrays.asList(administrador1, messi, jimHalpert));

      roles.forEach(repoRoles::save);

      //agregamos usuarios asociados con los roles

      Usuario admin1 = new Usuario("admin1", "qwerty", administrador1);
      Usuario usuarioMessi = new Usuario("messi2022", "qwerty", messi);
      Usuario usuarioJim = new Usuario("jim", "qwerty", jimHalpert);

      List<Usuario> usuarios = new ArrayList<>(Arrays.asList(admin1, usuarioJim, usuarioMessi));

      usuarios.forEach(repoUsuarios::save);


      //seteamos de los repositorios en el administrador

      administrador1.setRepoProductos(repoProductos);
      administrador1.setRepoPromociones(repoPromociones);

      //el administrador se encarga de guardar todos los productos al stock
      productosIniciales.forEach(administrador1::agregarProductoAlStock);


      PromoMedioDePago promoMedioDePago = new PromoMedioDePago(MedioDePago.EFECTIVO,0.05);
      PromoMedioDePago promoMedioDePagoDebito = new PromoMedioDePago(MedioDePago.TARJETA_DEBITO,0.02);
      Membresia membresia = new Membresia(Arrays.asList(messi, jimHalpert), 0.1);

      List<Promocion> promocionesIniciales = new ArrayList<>(Arrays.asList(promoMedioDePago, promoMedioDePagoDebito, membresia));

      //el administrador carga las promociones
      promocionesIniciales.forEach(administrador1::cargarPromocion);

     administrador1.eliminarPromocion(promoMedioDePagoDebito);
     administrador1.eliminarProductoDeStock(producto2);


     ///// ------- COMIENZA EL PROCESO DE COMPRA ------- ////



    CarritoDeCompras carritoDeCompra1 = new CarritoDeCompras(Arrays.asList(promoMedioDePago), LocalDate.now(), MedioDePago.EFECTIVO,messi,false);
     ItemVenta itemDeVenta1 = new ItemVenta(producto1,2, false);

     repoItemVentas.save(itemDeVenta1);
      ArrayList<ItemVenta> listaItem = new ArrayList<>();
      listaItem.add(itemDeVenta1);
      carritoDeCompra1.setItemsVentas(listaItem);

      registro.finalizarVenta(carritoDeCompra1);
      repoItemVentas.save(itemDeVenta1);
    }
  }
}
