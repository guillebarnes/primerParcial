package domain.entities.jugador.estados;

import domain.entities.jugador.Jugador;

public class Descansado implements Estado {
    private double limite;
    private double consumo;

    public Descansado() {
        this.limite = 0.3;
        this.consumo = 0.23;
    }

    public Descansado(double limite, double consumo) {
        this.limite = limite;
        this.consumo = consumo;
    }

    @Override
    public boolean puedeJugar(Jugador jugador) {
        return true;
    }

    @Override
    public void jugarPartido(Jugador jugador) {
        jugador.disminuirEnergia(consumo);
        if (jugador.getEnergia() <= limite) {
            jugador.setEstado(new Cansado());
        }
    }

    @Override
    public void descanso(Jugador jugador) {
        jugador.aumentarEnergia(consumo);
    }
}
