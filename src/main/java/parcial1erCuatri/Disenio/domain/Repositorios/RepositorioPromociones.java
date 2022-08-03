package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.stereotype.Repository;
import parcial1erCuatri.Disenio.domain.Venta.Promocion;

import java.util.Collection;

@Repository
public class RepositorioPromociones {
  private Collection<Promocion> promociones;

  public RepositorioPromociones(Collection<Promocion> promociones) {
    this.promociones = promociones;
  }
}
