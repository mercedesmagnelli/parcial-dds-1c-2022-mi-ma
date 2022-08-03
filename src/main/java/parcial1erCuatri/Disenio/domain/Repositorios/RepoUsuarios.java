package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import parcial1erCuatri.Disenio.domain.Roles.Rol;
import parcial1erCuatri.Disenio.domain.Venta.Producto;

public interface RepoUsuarios extends CrudRepository<Rol, Integer> {
}
