package parcial1erCuatri.Disenio.domain.Roles;

import parcial1erCuatri.Disenio.domain.Repositorios.RepositorioProductos;
import parcial1erCuatri.Disenio.domain.Venta.Producto;
import parcial1erCuatri.Disenio.domain.Venta.Promocion;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Rol {

    public Administrador(String nombre, String apellido, String mail,TipoDeDocumento tipoDocumento,String nroDeDocumento ,String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDeDocumento;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Administrador() {

    }

    public void agregarProductoAlStock(Producto p) {

        RepositorioProductos.getInstance().agregarProducto(p);

    }
    public void eliminarProductoDeStock(Producto producto) {
        RepositorioProductos.getInstance().eliminarProducto(producto);
    }
    public void cargarMasStockDeUnProducto(Producto p, int cantidad) {

    }

    public void cargarPromocion(Promocion promo) {

    }
    public void eliminarPromocion(Promocion promo) {

    }
}
