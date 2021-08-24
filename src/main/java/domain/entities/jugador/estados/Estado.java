package domain.entities.jugador.estados;

import domain.entities.jugador.Jugador;

public interface Estado {
    public boolean puedeJugar(Jugador jugador);

    public void jugarPartido(Jugador jugador) throws Exception;

    public void descanso(Jugador jugador);

}
