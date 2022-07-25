package domain.java.domain.Cotizador;




public final class CotizadorDolar implements Cotizador {

    @Override
    public Double cotizar() {
        return null;
    }

  /*  RestTemplate restTemplate = new RestTemplate();
    private Double precioDolar;
    private static CotizadorDolar cotizadorDolar;

    public  static CotizadorDolar getConfigurador() {

        if (cotizadorDolar==null) {

            cotizadorDolar = new CotizadorDolar();
        }
        return cotizadorDolar;
    }
    @Override
    public Double calcularPrecio(){
        //Double valor =this.run(restTemplate).getCompra();
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

    @Scheduled(fixedRate = 10006030)
    //@Scheduled(cron = "/01 * * *")
    public void actualizarPrecioDolar() {
        this.precioDolar = this.run(restTemplate).getCompra();
        System.out.println("Se actualizo el precio del dolar");
    }

    public CotizadorDolar() {
        super();
        this.precioDolar = this.run(restTemplate).getCompra();
    }

*/
}