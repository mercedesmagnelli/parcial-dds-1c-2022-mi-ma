package parcial1erCuatri.Disenio.domain.Venta;

import javax.persistence.*;

@Entity
@Table(name = "Promocion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.INTEGER)
public abstract class Promocion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Promocion() {

	}

	public abstract Double aplicar(CarritoDeCompras CarritoDeCompra);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}