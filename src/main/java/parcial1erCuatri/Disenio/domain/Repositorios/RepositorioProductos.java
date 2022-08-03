package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.stereotype.Repository;
import parcial1erCuatri.Disenio.domain.Venta.Producto;

import java.util.Collection;

@Repository
public class RepositorioProductos {
  private Collection<Producto> productos;

  public RepositorioProductos(Collection<Producto> productos) {
    this.productos = productos;
  }

  public Producto findByNombreAndDescripcion(String nombre,String descripcion) {
    return productos.stream().filter(producto -> producto.getNombre().equals(nombre) && producto.getDescripcion().equals(descripcion)).findFirst().get();
  }

  public void save(Producto producto){

  }
}
