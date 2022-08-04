package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import parcial1erCuatri.Disenio.domain.Venta.Producto;

import java.util.Optional;

@RepositoryRestResource(path="productos")
public interface RepoProductos extends CrudRepository<Producto, Integer> {
  Producto findByNombreAndDescripcion(String nombre,String descripcion);
}
