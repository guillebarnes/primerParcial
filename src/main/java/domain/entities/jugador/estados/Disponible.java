package domain.entities.jugador.estados;

public class Disponible implements Estado{

    @Override
    public boolean puedeJugar() {
        return true;
    }
}
