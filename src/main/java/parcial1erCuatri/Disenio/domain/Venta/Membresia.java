package parcial1erCuatri.Disenio.domain.Venta;

import parcial1erCuatri.Disenio.domain.Roles.Cliente;

import java.util.Collection;

public class Membresia extends Promocion {
	private Collection<Cliente> clientes;
	private Double porcentajeDescuento;

	@Override
	public Double aplicar(CarritoDeCompras carritoDeCompra) {
		if(clientes.contains(carritoDeCompra.getCliente())) {
			return carritoDeCompra.calcularPrecioTotalSinPromociones() * porcentajeDescuento;
		}else {
			return 0.0;
		}

	}

	protected Membresia() {
		super();
	}

	public Membresia(Collection<Cliente> clientes, double porcentajeDescuento) {
		super();
		this.clientes = clientes;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

}