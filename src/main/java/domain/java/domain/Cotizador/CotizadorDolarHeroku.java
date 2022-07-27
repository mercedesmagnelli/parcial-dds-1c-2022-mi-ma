package domain.java.domain.Cotizador;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public final class CotizadorDolarHeroku implements Cotizador {

    RestTemplate restTemplate = new RestTemplate();
    private Double precioDolar;
    private static CotizadorDolarHeroku cotizadorDolar;

    public  static CotizadorDolarHeroku getConfigurador() {

        if (cotizadorDolar==null) {

            cotizadorDolar = new CotizadorDolarHeroku();
        }
        return cotizadorDolar;
    }
    @Override
    public Double cotizar(){
        Double valor =this.run(restTemplate).getCompra();
        return valor;
    }

    public ApiPrecioDolar run(RestTemplate restTemplate) {
        ApiPrecioDolar precioActual = restTemplate.getForObject(
                "http://api-dolar-argentina.herokuapp.com/api/dolaroficial", ApiPrecioDolar.class);
        return precioActual;
    }

    public Double getPrecioDolar() {
        return precioDolar;
    }
    //CRON
    @Scheduled(fixedRate = 1000*60*30)
    //@Scheduled(cron = "/01 * * *")
    public void actualizarPrecioDolar() {
        this.precioDolar = this.run(restTemplate).getCompra();
        System.out.println("Se actualizo el precio del dolar" + precioDolar);
    }

    public CotizadorDolarHeroku() {
        super();
        this.precioDolar = this.run(restTemplate).getCompra();
    }

}