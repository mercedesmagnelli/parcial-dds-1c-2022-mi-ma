package parcial1erCuatri.Disenio.domain.Nivel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoProductos;
import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

@Component
public abstract class Nivel {

    //siendo que todos tienen maximo, no sé como setearlo en todos
    int maximo;
    @Autowired
    public RepoProductos repoProductos;

    public void setRepoProductos(RepoProductos repoProductos) {
        this.repoProductos = repoProductos;
    }

    public abstract ItemVenta beneficio() throws StockInsuficienteException;

    public abstract Nivel nivelSiguiente();

    public abstract int maximoEstrellasPermitidas();

}
