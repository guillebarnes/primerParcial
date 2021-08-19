package domain.entities.jugador.estados;

public class Lesionado implements Estado{
    @Override
    public boolean puedeJugar() {
        return false;
    }
}
