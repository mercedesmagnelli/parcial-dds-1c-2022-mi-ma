package parcial1erCuatri.Disenio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.stereotype.Service;
import parcial1erCuatri.Disenio.domain.Repositorios.*;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.Venta.*;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import javax.transaction.Transactional;

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


  public void registrarItemCarrito(CarritoDeCompras carritoDeCompras, ItemVenta itemVenta){
    carritoDeCompras.agregarItemAlCarrito(itemVenta);
    repoCarritos.save(carritoDeCompras);
    repoItemVentas.save(itemVenta);
  }

  public void eliminarItemCarrito(CarritoDeCompras carritoDeCompras, ItemVenta itemVenta){
    carritoDeCompras.eliminarItemAlCarrito(itemVenta);
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
