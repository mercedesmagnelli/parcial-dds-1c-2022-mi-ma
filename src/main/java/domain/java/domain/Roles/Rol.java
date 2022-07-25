package domain.java.domain.Roles;

public abstract class Rol {
    public String nombre;
    public String apellido;
    public String mail;
    public String telefono;

    public Rol(String nombre, String apellido, String mail, String tel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = tel;

    }
}