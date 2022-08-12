package parcial1erCuatri.Disenio.domain.Nivel;


import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;
import parcial1erCuatri.Disenio.domain.Venta.Producto;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

public class Bronce extends Nivel {

    public Bronce() {
        maximo = 500;
    }

    @Override
    public ItemVenta beneficio() throws StockInsuficienteException {
        return new ItemVenta(repoProductos.findByNombreAndDescripcion("Torta Oreo","Porcion pequeña"), 1, true);
    }

    @Override
    public Nivel nivelSiguiente() {

        return new Plata(repoProductos);
    }

    @Override
    public int maximoEstrellasPermitidas() {
        return maximo;
    }


}