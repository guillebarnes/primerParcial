package domain.entities.jugador.estados;

import domain.entities.jugador.Jugador;

public class Cansado implements Estado {
    private double energiaRecuperada;

    public Cansado() {
        this.energiaRecuperada = 0.25;
    }

    public Cansado(double energiaRecuperada) {
        this.energiaRecuperada = energiaRecuperada;
    }

    @Override
    public boolean puedeJugar(Jugador jugador) {
        return false;
    }

    @Override
    public void jugarPartido(Jugador jugador) {

    }

    @Override
    public void descanso(Jugador jugador) {
        jugador.aumentarEnergia(energiaRecuperada);
    }
}
