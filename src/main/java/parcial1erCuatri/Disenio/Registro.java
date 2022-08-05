package parcial1erCuatri.Disenio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.stereotype.Service;
import parcial1erCuatri.Disenio.domain.Repositorios.*;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.Venta.*;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import java.time.LocalDate;
import java.util.ArrayList;
@Service
public class Registro {
  @Autowired
  private RepoPromociones repoPromociones;
  @Autowired
  private RepoProductos repoProductos;
  @Autowired
  private RepoRoles repoRoles;
  @Autowired
  private RepoVentas repoVentas;
  @Autowired
  private RepoCarritos repoCarritos;
  @Autowired
  private RepoItemVentas repoItemVentas;

  public Registro() {

  }

  //Cosas del admi
  public void setRepoPromociones(RepoPromociones repoPromociones) {
    this.repoPromociones= repoPromociones;
  }

  public void setRepoProductos(RepoProductos repoProductos) {
    this.repoProductos = repoProductos;
  }

  //@Transactional
  public void agregarProductoAlStock(Producto producto) {
    repoProductos.save(producto);
  }
  //fachada.guardarProducto(Produ)

  public void eliminarProductoDeStock(Producto producto) {
    repoProductos.delete(producto);
  }

  public void cargarMasStockDeUnProducto(Producto p, int cantidad) {
    Producto producto= repoProductos.findById(p.getId()).get();

    producto.setStock(cantidad);
  }

  public void cargarPromocion(Promocion promo) {
    repoPromociones.save(promo);
  }
  public void eliminarPromocion(Promocion promo) {
    repoPromociones.delete(promo);
  }

  //Cosas del cliente
  /*
  1- Registrar item
   */
  public void registrarItemCarrito(CarritoDeCompras carritoDeCompras, ItemVenta itemVenta){
    carritoDeCompras.agregarItemAlCarrito(itemVenta);
    repoCarritos.save(carritoDeCompras);
    repoItemVentas.save(itemVenta);
  }

  public void finalizarVenta(CarritoDeCompras carritoDeCompras) throws StockInsuficienteException {
    Venta venta = carritoDeCompras.generarVenta();
    repoVentas.save(venta);
    Cliente cliente = carritoDeCompras.getCliente();
    cliente.realizarComprar(venta);
    carritoDeCompras.limpiarCarrito();
    repoRoles.save(cliente);
    repoCarritos.save(carritoDeCompras);
  }

}
