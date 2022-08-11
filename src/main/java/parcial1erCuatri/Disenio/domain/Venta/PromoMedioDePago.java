package parcial1erCuatri.Disenio.domain.Venta;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@Entity
@DiscriminatorValue("MedioDePago")
public class PromoMedioDePago extends Promocion{
	@Enumerated(EnumType.STRING)
	@Column(name = "medioDePago")
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
			return carritoDeCompra.calcularPrecioTotalSinPromociones() * porcentaje;
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
