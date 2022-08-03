package parcial1erCuatri.Disenio.domain.Repositorios;

import parcial1erCuatri.Disenio.domain.Venta.Producto;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Collection;


public class RepositorioProductos implements WithGlobalEntityManager {

    private Collection<Producto> productos;

    private static final RepositorioProductos INSTANCE = new RepositorioProductos();

    public static RepositorioProductos getInstance()  {
        return INSTANCE;
    }

    public Collection<Producto> getProductos() {
        return productos;
    }

   /* public Producto buscarProducto(Producto p, String tabla) {
        EntityManager em = this.entityManager();

        return (Producto) em.createQuery("from " + tabla + " p where p.descripcion = "
                            + ":nombreDeUsuario and t.contrasenia = :contrasenia")
                    .setParameter("nombreDeUsuario", nombreUsuario)
                    .setParameter("contrasenia", contrasenia)
                    .getSingleResult();



    }*/

    public void agregarProducto(Producto p) {

         EntityManager em = this.entityManager();

    }

    public void eliminarProducto(Producto p) {
        productos.remove(p);
    }

    public void cargarStock(Producto p, int cantidad) {
       Producto prodEncontrado = productos.stream().filter(pr -> pr.getNombre() == p.getNombre() && pr.getDescripcion() == p.getDescripcion()).findFirst().get();
       prodEncontrado.setStock(prodEncontrado.getStock() + cantidad);
    }

    //de esto lo que no me gusta es que buscamos por sting :P

    public Producto obtenerBeneficioOro() {
    return productos.stream().filter(p -> p.getDescripcion() == "Porcion pequeña" && p.getNombre() == "Lemon Pie").findFirst().get();
    }

    public Producto obtenerBeneficioPlata() {
        return productos.stream().filter(p -> p.getDescripcion() == "Porcion mediana" && p.getNombre() == "Chocotorta").findFirst().get();
    }

    public Producto obtenerBeneficioBronce() {
        return productos.stream().filter(p -> p.getDescripcion() == "Porcion grande" && p.getNombre() == "Torta Oreo").findFirst().get();
    }


}
