package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import parcial1erCuatri.Disenio.domain.Roles.Cliente;
import parcial1erCuatri.Disenio.domain.Venta.CarritoDeCompras;
import parcial1erCuatri.Disenio.domain.Venta.Producto;

import java.util.Optional;

public interface RepoCarritos extends CrudRepository<CarritoDeCompras, Integer> {
  Optional<CarritoDeCompras> findByCliente(Cliente cliente);
}
