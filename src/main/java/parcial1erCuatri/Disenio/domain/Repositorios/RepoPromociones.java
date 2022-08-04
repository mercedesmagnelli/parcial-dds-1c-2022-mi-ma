package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import parcial1erCuatri.Disenio.domain.Venta.Promocion;

@RepositoryRestResource(path="promociones")
public interface RepoPromociones extends CrudRepository<Promocion, Integer> {
}
