package parcial1erCuatri.Disenio.domain.Cotizador;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public final class CotizadorDolar{
    RestTemplate restTemplate = new RestTemplate();
    private double precioDolar;
    private static CotizadorDolar cotizadorDolar;

    public  static CotizadorDolar getConfigurador() {

        if (cotizadorDolar==null) {

            cotizadorDolar = new CotizadorDolar();
        }
        return cotizadorDolar;
    }

    public ApiPrecioDolar run(RestTemplate restTemplate) {
        ApiPrecioDolar precioActual = restTemplate.getForObject(
            "http://api-dolar-argentina.herokuapp.com/api/dolaroficial", ApiPrecioDolar.class);
        return precioActual;
    }

    public double getPrecioDolar() {
        return precioDolar;
    }

    @Scheduled(fixedRate = 1000)
    public void actualizarPrecioDolar() {
        this.precioDolar = this.run(restTemplate).getCompra();
        System.out.println("Se actualizo el precio del dolar");
    }

    public CotizadorDolar() {
          this.precioDolar = this.run(restTemplate).getCompra();
    }

}