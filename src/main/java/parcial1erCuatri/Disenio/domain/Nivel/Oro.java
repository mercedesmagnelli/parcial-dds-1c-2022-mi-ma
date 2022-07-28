package parcial1erCuatri.Disenio.domain.Nivel;

import parcial1erCuatri.Disenio.domain.Repositorios.RepositorioProductos;
import parcial1erCuatri.Disenio.domain.Venta.ItemVenta;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

public class Oro extends Nivel {


   public Oro() {
        maximo = 1000000000;
    }

    @Override
    public ItemVenta beneficio() throws StockInsuficienteException {

       //aca me resulta raro que tengamos que hacer un new del producto, capaz podemos hacer una busqueda
    return new ItemVenta(RepositorioProductos.getInstance().obtenerBeneficioOro(), 1, true);
    }

    public Nivel nivelSiguiente() {
        //bueno, acá queda raro porque como que entra en un loop
        return new Oro();
    }
    @Override
    public int maximoEstrellasPermitidas() {
        return maximo;
    }
}
