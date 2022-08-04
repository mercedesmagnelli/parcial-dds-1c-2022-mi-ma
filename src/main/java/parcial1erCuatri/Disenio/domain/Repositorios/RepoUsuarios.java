package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import parcial1erCuatri.Disenio.domain.Roles.Rol;
import parcial1erCuatri.Disenio.domain.Venta.Producto;

@RepositoryRestResource(path="roles")
public interface RepoUsuarios extends CrudRepository<Rol, Integer> {
}
