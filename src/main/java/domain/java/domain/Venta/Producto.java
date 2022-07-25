package domain.java.domain.Venta;

import domain.java.domain.exceptions.StockInsuficienteException;

public class Producto {
	private Integer id;
	private Double precio;
	private String descripcion;
	private String nombre;
	private int stock;
	private String imagen;
	
	public Producto() {
		super();
	}
	
	public Producto( String descripcion,String nombre,Double precio, int stock,Boolean estaEnDolares,String imagen) {
		super();
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio= precio;
		//this.estaDisponible = estaDisponible;
		this.stock = stock;
		this.imagen=imagen;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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