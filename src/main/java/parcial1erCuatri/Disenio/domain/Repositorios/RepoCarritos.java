package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import parcial1erCuatri.Disenio.domain.Venta.CarritoDeCompras;
import parcial1erCuatri.Disenio.domain.Venta.Producto;

public interface RepoCarritos extends CrudRepository<CarritoDeCompras, Integer> {
}
