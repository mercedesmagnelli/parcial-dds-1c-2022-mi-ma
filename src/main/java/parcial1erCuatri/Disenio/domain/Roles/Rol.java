package parcial1erCuatri.Disenio.domain.Roles;

import javax.persistence.*;

@Entity
@Table(name = "Rol")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.STRING)
public abstract class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public String nombre;
    public String apellido;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDeDocumento")
    public TipoDeDocumento tipoDocumento;
    public String nroDocumento;
    public String mail;
    public String telefono;

}