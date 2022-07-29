package parcial1erCuatri.Disenio.domain.Roles;

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
}
