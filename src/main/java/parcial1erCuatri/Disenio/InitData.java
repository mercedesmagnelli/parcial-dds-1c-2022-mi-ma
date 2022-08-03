package parcial1erCuatri.Disenio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoProductos;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoPromociones;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoUsuarios;
import parcial1erCuatri.Disenio.domain.Roles.Administrador;
import parcial1erCuatri.Disenio.domain.Roles.TipoDeDocumento;
import parcial1erCuatri.Disenio.domain.Venta.MedioDePago;
import parcial1erCuatri.Disenio.domain.Venta.Membresia;
import parcial1erCuatri.Disenio.domain.Venta.Producto;
import parcial1erCuatri.Disenio.domain.Venta.PromoMedioDePago;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
  @Autowired
  RepoProductos repoProductos;
  @Autowired
  RepoPromociones repoPromociones;
  @Autowired
  RepoUsuarios repoUsuarios;

  @Override
  public void run(String... args) throws Exception {
    if (repoProductos.count() >= 0) {
      Producto producto1= new Producto("Bebida" , "Coca cola", 150.0, 5);
      Producto producto2= new Producto("Snacks" , "chetos", 50.0, 5);

      List<Producto> productosIniciales = new ArrayList<>();
      productosIniciales.add(producto1);

      productosIniciales.stream().forEach(producto -> {
        repoProductos.save(producto);
      });

   //   ItemVenta itemDeCompra1 = new ItemVenta(producto1,2, false);
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
    }
  }
}
