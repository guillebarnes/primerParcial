package domain.validador;

import domain.entities.club.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ValidadorReserva {
    private List<CriterioReserva> criteriosReserva;

    public ValidadorReserva() {
        this.criteriosReserva = new ArrayList<>();
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
