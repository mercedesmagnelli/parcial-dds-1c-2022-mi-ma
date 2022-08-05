package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import parcial1erCuatri.Disenio.domain.Venta.CarritoDeCompras;
import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;

public interface RepoItemVentas extends CrudRepository<ItemVenta, Integer> {
}
