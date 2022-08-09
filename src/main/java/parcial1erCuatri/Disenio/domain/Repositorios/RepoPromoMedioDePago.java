package parcial1erCuatri.Disenio.domain.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import parcial1erCuatri.Disenio.domain.Venta.PromoMedioDePago;
import parcial1erCuatri.Disenio.domain.Venta.Promocion;

@RepositoryRestResource(path="promoMedioDepago")
public interface RepoPromoMedioDePago extends CrudRepository<PromoMedioDePago, Integer> {
}
