package parcial1erCuatri.Disenio.domain.Roles;

import parcial1erCuatri.Disenio.domain.MedioDeNotificacion.MedioDeComunicacion;
import parcial1erCuatri.Disenio.domain.Nivel.Bronce;
import parcial1erCuatri.Disenio.domain.Nivel.Nivel;
import parcial1erCuatri.Disenio.domain.Venta.Venta;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;


import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Rol {
    //cambiar nombre a comprasRealizadas
		private ArrayList<Venta> ventas;
		private LocalDate fechaDeNac;
		private TipoDeDocumento tipoDocumento;
		private String nroDocumento;
    private int estrellas;
    private Nivel nivel;
    private MedioDeComunicacion medioPreferido;


	public Cliente(String nombre, String apellido, String mail, String telefono, LocalDate fechaDeNacimiento, TipoDeDocumento tipoDocumento, String nroDeDocumento) {
		super(nombre, apellido, mail, telefono);
		this.ventas = new ArrayList<>();
		this.fechaDeNac = fechaDeNacimiento;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDeDocumento;
		//arranca con 0 estrellas
		this.estrellas = 0;
		//que arranque con Bronce seteado
		this.nivel = new Bronce();
		//this.medioPreferido = medio;
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

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public LocalDate getFechaDeNac() {
		return fechaDeNac;
	}

	public void setFechaDeNac(LocalDate fechaDeNac) {
		this.fechaDeNac = fechaDeNac;
	}

	public TipoDeDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDeDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public MedioDeComunicacion getMedioPreferido() {
		return medioPreferido;
	}

	public void setMedioPreferido(MedioDeComunicacion medioPreferido) {
		this.medioPreferido = medioPreferido;
	}

	// Funciones
	public void realizarComprar(Venta v) throws StockInsuficienteException {
		ventas.add(v);
		sumarEstrellas(v.getPrecioTotalConDescuento());
		v.agregarBeneficio(nivel.beneficio());
	}

	public void sumarEstrellas(Double precio) {
		estrellas += precio / 100;
		if(estrellas > nivel.maximoEstrellasPermitidas()) {
			nivel = nivel.nivelSiguiente();
		}
	}

	
}
