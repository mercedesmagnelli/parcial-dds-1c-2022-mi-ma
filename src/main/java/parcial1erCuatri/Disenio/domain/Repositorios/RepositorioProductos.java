package parcial1erCuatri.Disenio.domain.Repositorios;

import parcial1erCuatri.Disenio.domain.Venta.Producto;

import java.util.Collection;

public class RepositorioProductos {
    private static final RepositorioProductos INSTANCE = new RepositorioProductos();

    private Collection<Producto> productos;

    public static RepositorioProductos getInstance()  {
        return INSTANCE;
    }

    public Collection<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    //de esto lo que no me gusta es que buscamos por sting :P

    public Producto obtenerBeneficioOro() {
    return productos.stream().filter(p -> p.getDescripcion() == "Beneficio Oro").findFirst().get();
    }

    public Producto obtenerBeneficioPlata() {
        return productos.stream().filter(p -> p.getDescripcion() == "Beneficio Plata").findFirst().get();
    }

    public Producto obtenerBeneficioBronce() {
        return productos.stream().filter(p -> p.getDescripcion() == "Beneficio Bronce").findFirst().get();
    }

}
