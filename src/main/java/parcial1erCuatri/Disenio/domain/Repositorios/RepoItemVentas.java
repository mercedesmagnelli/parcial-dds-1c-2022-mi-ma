package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import parcial1erCuatri.Disenio.domain.Venta.CarritoDeCompras;
import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;

@RepositoryRestResource(path="itemsVenta")
public interface RepoItemVentas extends CrudRepository<ItemVenta, Integer> {
}
