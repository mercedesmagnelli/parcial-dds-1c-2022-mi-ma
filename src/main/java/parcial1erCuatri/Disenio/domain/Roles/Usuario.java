package parcial1erCuatri.Disenio.domain.Roles;

import parcial1erCuatri.Disenio.domain.Repositorios.RepoPromociones;

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
