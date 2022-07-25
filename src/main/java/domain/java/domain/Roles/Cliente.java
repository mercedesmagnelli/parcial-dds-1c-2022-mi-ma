package domain.java.domain.Roles;

import domain.java.domain.Venta.CarritoDeCompras;
import domain.java.domain.MedioDeNotificacion.MedioDeComunicacion;
import domain.java.domain.Nivel.Nivel;
import domain.java.domain.Venta.Venta;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Rol {
    //cambiar nombre a comprasRealizadas
    public ArrayList<Venta> ventas;
    public LocalDate fechaDeNac;
    public TipoDeDocumento tipoDocumento;
    public String nroDocumento;
    public CarritoDeCompras carrito;
    private int estrellas;
    private Nivel nivel;
    private MedioDeComunicacion medioPreferido;


	public Cliente(String nombre, String apellido, String mail, String telefono, LocalDate fechaDeNacimiento, TipoDeDocumento tipoDocumento, String nroDeDocumento, CarritoDeCompras carrito, MedioDeComunicacion medio) {
		super(nombre, apellido, mail, telefono);
		this.ventas = new ArrayList<>();
		this.fechaDeNac = fechaDeNacimiento;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDeDocumento;
        this.carrito = carrito;
        this.medioPreferido = medio;
	}
	

	public ArrayList<Venta> getVentas() {
		return ventas;
	}


	public LocalDate getFechaDeNacimiento() {
		return fechaDeNac;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNac = fechaDeNacimiento;
	}
	public TipoDeDocumento getTipoDeDocumento() {
		return tipoDocumento;
	}
	public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
		this.tipoDocumento = tipoDeDocumento;
	}
	public String getNroDeDocumento() {
		return nroDocumento;
	}
	public void setNroDeDocumento(String nroDeDocumento) {
		this.nroDocumento = nroDeDocumento;
	}
	
	// Funciones
	public void realizarComprar(Venta v) {
		ventas.add(v);
	}
	
}
