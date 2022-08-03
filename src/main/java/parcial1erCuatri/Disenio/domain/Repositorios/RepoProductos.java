package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import parcial1erCuatri.Disenio.domain.Venta.Producto;

import java.util.Optional;


public interface RepoProductos extends CrudRepository<Producto, Integer> {
  Producto findByNombreAndDescripcion(String nombre,String descripcion);
}
