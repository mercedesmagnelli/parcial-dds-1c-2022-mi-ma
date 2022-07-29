package parcial1erCuatri.Disenio.domain.Roles;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String usuario;
    private String contrasenia;
    @ManyToOne
    private Rol rol;

    public void validarContrasenia() {

    }
    
}
