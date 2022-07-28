package parcial1erCuatri.Disenio.domain.Venta;


import parcial1erCuatri.Disenio.domain.exceptions.StockInsuficienteException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Double precio;
	private String descripcion;
	private String nombre;
	private int stock;
	
	public Producto() {
		super();
	}
	
	public Producto(String descripcion,String nombre,Double precio, int stock) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio= precio;
		//this.estaDisponible = estaDisponible;
		this.stock = stock;
	}
	
	public Double getPrecio() {
			return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//Funciones

	public void restarStock(int cantidad) throws StockInsuficienteException {
		if(stock<cantidad){
			throw new StockInsuficienteException("El stock es insuficiente en el producto");
		}
		this.stock= stock- cantidad;
	}

	//public double calcularPrecioEnDolar(){}
}