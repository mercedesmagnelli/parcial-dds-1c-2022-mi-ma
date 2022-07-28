package parcial1erCuatri.Disenio.domain.Venta;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Venta{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany
	@JoinColumn(name = "ordenDeCompra_id")
	private Collection<ItemVenta> itemsVenta;
	private MedioDePago medioDePago;
    private LocalDate fechaDeVenta;
	//Una vez que se termina de hacer la ordenDeCompra en el carrito y se la paga (Aceptandola). Se hace un new a OrdenDeCompra con todos los atributos que tenga el carrito y se agrega el precioTotalConDescuento y precioTotalSinDescuento de los métodos de carrito
	private double precioTotalSinDescuento;
	private double precioTotalConDescuento;

	public Venta(){
		super();
	}

	public Venta(
            LocalDate fechaDeVenta, MedioDePago medioDePago, double precioTotalSinDescuento , double precioTotalConDescuento) {
		this.itemsVenta = new ArrayList<>();
		this.medioDePago = medioDePago;
        this.fechaDeVenta=fechaDeVenta;
		this.precioTotalSinDescuento=precioTotalSinDescuento;
		this.precioTotalConDescuento=precioTotalConDescuento;
	}

	public Collection<ItemVenta> getItemsVentas() {
		return itemsVenta;
	}

	public void setItemsVentas(Collection<ItemVenta> itemsVentas) {
		this.itemsVenta = itemsVentas;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public double getPrecioTotalSinDescuento() {
		return precioTotalSinDescuento;
	}

	public void setPrecioTotalSinDescuento(double precioTotalSinDescuento) {
		this.precioTotalSinDescuento = precioTotalSinDescuento;
	}

	public double getPrecioTotalConDescuento() {
		return precioTotalConDescuento;
	}

	public void setPrecioTotalConDescuento(double precioTotalConDescuento) {
		this.precioTotalConDescuento = precioTotalConDescuento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(Collection<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}

	public LocalDate getFechaDeVenta() {
		return fechaDeVenta;
	}

	public void setFechaDeVenta(LocalDate fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}
}