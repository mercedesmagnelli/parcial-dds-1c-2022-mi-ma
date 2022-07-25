package domain.java.domain.Venta;

import domain.java.domain.Roles.Cliente;
import domain.java.domain.Venta.MedioDePago;
import domain.java.domain.Venta.Promocion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class CarritoDeCompras {

    private Collection<ItemVenta> itemsVentas;
    private Collection<Promocion> promociones;
    private LocalDate fechaDeVenta;
    private MedioDePago medioDePago;
    private Cliente cliente;
    private boolean estaEnDolares;

    public CarritoDeCompras(Collection<Promocion> promociones, LocalDate fechaDeVenta, MedioDePago medioDePago, Cliente cliente, boolean estaEnDolares) {
        super();
        this.itemsVentas = new ArrayList<>();
        this.promociones = promociones;
        this.fechaDeVenta = fechaDeVenta;
        this.medioDePago = medioDePago;
        this.cliente=cliente;
        this.estaEnDolares=estaEnDolares;
    }

    public Collection<ItemVenta> getItemsCompras() {
        return itemsVentas;
    }

    public void setItemsCompras(Collection<ItemVenta> itemsVentas) {
        this.itemsVentas = itemsVentas;
    }

    public Collection<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(Collection<Promocion> promociones) {
        this.promociones = promociones;
    }

    public LocalDate getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(LocalDate fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getEstaEnDolares() {
        return estaEnDolares;
    }

    public void setEstaEnDolares(Boolean estaEnDolares) {
        this.estaEnDolares = estaEnDolares;
    }


    public double calcularPrecioTotalSinPromociones(){
        return itemsVentas.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
    }

    public double calcularPrecioTotalConPromociones(){
        return this.calcularPrecioTotalSinPromociones()-promociones.stream().mapToDouble(x->x.aplicar(this)).sum();
    }




   /* public double calcularPrecioTotalSinPromociones(){
        if(this.getEstaEnDolares()) {
            CotizadorDolar cotizadorDolar = CotizadorDolar.getConfigurador();
            return itemsVentas.stream().mapToDouble(x->x.calcularPrecioItem()).sum() * cotizadorDolar.getPrecioDolar();
        }else{
            return itemsVentas.stream().mapToDouble(x->x.calcularPrecioItem()).sum();
        }
    }

    public double calcularPrecioTotalConPromociones(){
        if(this.getEstaEnDolares()){
            CotizadorDolar cotizadorDolar = CotizadorDolar.getConfigurador();
            return this.calcularPrecioTotalSinPromociones()-promociones.stream().mapToDouble(x->x.aplicar(this)).sum() * cotizadorDolar.getPrecioDolar();
        }else{
            return this.calcularPrecioTotalSinPromociones()-promociones.stream().mapToDouble(x->x.aplicar(this)).sum()
        }
    }
}*/

}
