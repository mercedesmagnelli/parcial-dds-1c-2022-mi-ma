package parcial1erCuatri.Disenio.domain.Venta;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MedioDePago")
public class PromoMedioDePago extends Promocion {
	private MedioDePago medioDePago;
	private Double porcentaje;
	
	protected PromoMedioDePago() {
		super();
	}
	
	public PromoMedioDePago(MedioDePago medioDePago, double porcentaje) {
		super();
		this.medioDePago = medioDePago;
		this.porcentaje = porcentaje;
	}

	@Override
	public Double aplicar(CarritoDeCompras carritoDeCompra) {
		if(carritoDeCompra.getMedioDePago().equals(this.medioDePago)) {
			return carritoDeCompra.calcularPrecio() * porcentaje;
		}
		return 0.0;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
}