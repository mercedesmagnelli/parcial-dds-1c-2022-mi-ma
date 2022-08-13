package parcial1erCuatri.Disenio.domain.Roles;


import parcial1erCuatri.Disenio.domain.MailSender;
import parcial1erCuatri.Disenio.domain.Nivel.Bronce;
import parcial1erCuatri.Disenio.domain.Nivel.Nivel;
import parcial1erCuatri.Disenio.domain.Venta.CarritoDeCompras;
import parcial1erCuatri.Disenio.domain.Venta.Venta;
import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@DiscriminatorValue("C")
public class Cliente extends Rol {
    //cambiar nombre a comprasRealizadas
	@OneToMany
	@JoinColumn(name = "cliente_id")
	private Collection<Venta> ventas;
    private int estrellas;
    @Transient
    private Nivel nivel;
		@Transient
		private Boolean recibirPorMail;

	public Cliente(String nombre, String apellido, String mail, String telefono, TipoDeDocumento tipoDocumento, String nroDeDocumento, Boolean recibirPorMail) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDeDocumento;
		this.mail = mail;
		this.telefono = telefono;
		this.ventas = new ArrayList<>();
		//arranca con 0 estrellas
		this.estrellas = 0;
		//que arranque con Bronce seteado
		this.nivel = new Bronce();
		this.recibirPorMail = recibirPorMail;
	}

	public Cliente() {
		super();
	}

	public Collection<Venta> getVentas() {
		return ventas;
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

	public void setVentas(Collection<Venta> ventas) {
		this.ventas = ventas;
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


	// Funciones
	public void realizarComprar(Venta v) throws StockInsuficienteException {
		ventas.add(v);
		sumarEstrellas(v.getPrecioTotalConDescuento());
		v.agregarBeneficio(nivel.beneficio());
		if(recibirPorMail) {
			MailSender.getInstance().enviarDetalleDeCompra(mail, v);
		}
	}

	public void sumarEstrellas(Double precio) {
		estrellas += precio / 100;
		if(estrellas > nivel.maximoEstrellasPermitidas()) {
			nivel = nivel.nivelSiguiente();
		}
	}

	
}
