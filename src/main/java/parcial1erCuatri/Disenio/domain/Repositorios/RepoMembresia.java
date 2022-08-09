package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import parcial1erCuatri.Disenio.domain.Venta.Membresia;

@RepositoryRestResource(path="membresia")
public interface RepoMembresia extends CrudRepository<Membresia, Integer> {
}
