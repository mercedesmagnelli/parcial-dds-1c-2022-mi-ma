package parcial1erCuatri.Disenio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.stereotype.Service;
import parcial1erCuatri.Disenio.domain.Repositorios.*;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.Venta.*;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import javax.transaction.Transactional;
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
  @Transactional
  public void registrarItemCarrito(CarritoDeCompras carritoDeCompras, ItemVenta itemVenta){
    repoItemVentas.save(itemVenta);
    carritoDeCompras.agregarItemAlCarrito(itemVenta);
    repoCarritos.save(carritoDeCompras);

  }

  @Transactional
  public void finalizarVenta(CarritoDeCompras carritoDeCompras) throws StockInsuficienteException {
    Venta venta = carritoDeCompras.generarVenta();
    repoVentas.save(venta);
    Cliente cliente = carritoDeCompras.getCliente();
    cliente.realizarComprar(venta);
    repoRoles.save(cliente);
    carritoDeCompras.limpiarCarrito();
    repoCarritos.save(carritoDeCompras);
  }

}
