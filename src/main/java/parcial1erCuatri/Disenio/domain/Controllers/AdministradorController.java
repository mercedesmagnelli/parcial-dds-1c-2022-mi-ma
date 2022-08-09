package parcial1erCuatri.Disenio.domain.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoProductos;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoPromociones;
import parcial1erCuatri.Disenio.domain.Venta.Producto;
import parcial1erCuatri.Disenio.domain.Venta.Promocion;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {
  @Autowired
  RepoPromociones repoPromociones;
  @Autowired
  private RepoProductos repoProductos;

  @Transactional
  @PostMapping("/promociones")
  public void agregarPromocion(@RequestBody Promocion promocion){
    repoPromociones.save(promocion);
  }

  @Transactional
  @RequestMapping(method = RequestMethod.DELETE,value="/promociones/{promocionID}")
  public void eliminarPromocion(@PathVariable("vendedorID") Promocion promocion){
    repoPromociones.delete(promocion);
  }

  @Transactional
  @PostMapping("/productos")
  public void agregarProducto(@RequestBody Producto producto){
    repoProductos.save(producto);
  }
}
