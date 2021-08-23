package domain.validador;

import domain.entities.club.Reserva;
import domain.entities.club.Ubicacion;

public class CriterioClima implements CriterioReserva {
    private AdapterClima servicioClima;

    public CriterioClima(AdapterClima servicioClima) {
        this.servicioClima = servicioClima;
    }

    public AdapterClima getServicioClima() {
        return servicioClima;
    }

    public void setServicioClima(AdapterClima servicioClima) {
        this.servicioClima = servicioClima;
    }

    @Override
    public boolean esValida(Reserva reserva) {
        Ubicacion ubicacion = reserva.getCancha().getUbicacion();
        return reserva.getCancha().esTechada() || servicioClima.noLlueveEn(ubicacion);
    }
}
