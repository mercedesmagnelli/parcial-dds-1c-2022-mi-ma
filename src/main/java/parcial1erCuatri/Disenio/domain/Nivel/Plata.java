package parcial1erCuatri.Disenio.domain.Nivel;

import parcial1erCuatri.Disenio.domain.Repositorios.RepoProductos;
import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

public class Plata extends Nivel {

    public Plata(RepoProductos repo) {
        repoProductos = repo;
        maximo = 1000;
    }

    @Override
    public ItemVenta beneficio() throws StockInsuficienteException {
    return new ItemVenta(repoProductos.findByNombreAndDescripcion("Chocotorta","Porcion mediana"), 1, true);
    }

    @Override
    public Nivel nivelSiguiente() {
        return new Oro(repoProductos);
    }

    @Override
    public int maximoEstrellasPermitidas() {
        return 0;
    }
}