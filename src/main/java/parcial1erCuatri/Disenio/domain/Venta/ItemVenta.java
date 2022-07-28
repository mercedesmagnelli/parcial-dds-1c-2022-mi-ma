package parcial1erCuatri.Disenio.domain.Venta;

import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import javax.persistence.*;

@Entity
public class ItemVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Producto producto;
	private int cantidad;
	private double precioCompra;
	
	public ItemVenta(){
		super();
	}

	//
	public ItemVenta(Producto producto, int cantidad, Boolean esBeneficio) throws StockInsuficienteException {
		super();
		producto.restarStock(cantidad);
		this.producto = producto;
		this.cantidad = cantidad;
		if(esBeneficio) {
			this.precioCompra = 0;
		}else {
			this.precioCompra = producto.getPrecio();
		}

	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioCompra() {
		return producto.getPrecio();
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	//Funciones
	public double calcularPrecioItem(){
		return this.cantidad * this.precioCompra;
	}


}