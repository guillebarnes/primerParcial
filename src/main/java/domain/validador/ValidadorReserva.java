package domain.validador;

import domain.entities.club.Reserva;
import domain.validador.climaAPI.ServicioClimaWeatherbit;

import java.util.ArrayList;
import java.util.List;

public class ValidadorReserva {

    private List<CriterioReserva> criteriosReserva;

    public ValidadorReserva() {
        this.criteriosReserva = new ArrayList<>();
        AdapterClima adapterClima = ServicioClimaWeatherbit.getInstancia();


        this.agregarCriterio(new CriterioEstadoJugadores());
        this.agregarCriterio(new CriterioMinimoJugador(4));
        this.agregarCriterio(new CriterioClima(adapterClima));
    }

    public void agregarCriterio(CriterioReserva criterioReserva) {
        this.criteriosReserva.add(criterioReserva);
    }

    public void quitarCriterio(CriterioReserva criterioReserva) {
        this.criteriosReserva.remove(criterioReserva);
    }

    public boolean valida(Reserva reserva) {
        return this.criteriosReserva.stream().allMatch(criterioReserva -> criterioReserva.esValida(reserva));
    }
}
