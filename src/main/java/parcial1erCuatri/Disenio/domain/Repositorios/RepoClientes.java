package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;

@RepositoryRestResource(path="clientes")
public interface RepoClientes extends CrudRepository<Cliente, Integer> {
}
