package domain.entities.jugador.estados;

import domain.entities.jugador.Jugador;

public class Descansado implements Estado {
    private double consumo;

    public Descansado() {
        this.consumo = 0.15;
    }

    public Descansado(double consumo) {
        this.consumo = consumo;
    }

    @Override
    public boolean puedeJugar(Jugador jugador) {
        return true;
    }

    @Override
    public void jugarPartido(Jugador jugador) {
        jugador.disminuirEnergia(consumo);
        if (jugador.estaCansado())
            jugador.setEstado(new Cansado());

    }

    @Override
    public void descanso(Jugador jugador) {
        jugador.aumentarEnergia(consumo);
    }

}
