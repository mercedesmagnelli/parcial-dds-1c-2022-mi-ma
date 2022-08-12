package parcial1erCuatri.Disenio.domain.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoProductos;
import parcial1erCuatri.Disenio.domain.Repositorios.RepoPromociones;
import parcial1erCuatri.Disenio.domain.Venta.Producto;
import parcial1erCuatri.Disenio.domain.Venta.Promocion;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Rol {
    @Transient
    RepoPromociones repoPromociones;
    @Transient
    RepoProductos repoProductos;

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

    public void setRepoPromociones(RepoPromociones repoPromociones) {
        this.repoPromociones= repoPromociones;
    }

    public void setRepoProductos(RepoProductos repoProductos) {
        this.repoProductos = repoProductos;
    }

    public void agregarProductoAlStock(Producto producto) {
        repoProductos.save(producto);
    }

    public void eliminarProductoDeStock(Producto producto) {
       repoProductos.delete(producto);
    }

    public void cargarMasStockDeUnProducto(Producto p, int cantidad) {
        Producto producto = repoProductos.findById(p.getId()).get();
        producto.sumarStock(cantidad);
        repoProductos.save(producto);
    }

    public void cargarPromocion(Promocion promo) {
    repoPromociones.save(promo);
    }
    public void eliminarPromocion(Promocion promo) {
    repoPromociones.delete(promo);
    }

}
