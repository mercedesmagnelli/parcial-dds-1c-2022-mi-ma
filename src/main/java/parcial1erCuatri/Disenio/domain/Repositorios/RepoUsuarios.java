package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import parcial1erCuatri.Disenio.domain.Roles.Usuario;
import parcial1erCuatri.Disenio.domain.Venta.Venta;

public interface RepoUsuarios extends CrudRepository<Usuario, Integer> {
}
