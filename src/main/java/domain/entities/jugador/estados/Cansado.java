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
    public void jugarPartido(Jugador jugador) throws Exception {
        String mensaje = jugador.getNombre() + " " + jugador.getApellido() + " " + "no puede jugar partido por estar cansado";
        throw new Exception(mensaje);
    }

    @Override
    public void descanso(Jugador jugador) {
        jugador.aumentarEnergia(energiaRecuperada);
        if (!jugador.estaCansado())
            jugador.setEstado(new Descansado());
    }

}
