package parcial1erCuatri.Disenio.domain.Nivel;

import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

public abstract class Nivel {

    //siendo que todos tienen maximo, no sé como setearlo en todos
    int maximo;

    public abstract ItemVenta beneficio() throws StockInsuficienteException;

    public abstract Nivel nivelSiguiente();

    public abstract int maximoEstrellasPermitidas();

}
