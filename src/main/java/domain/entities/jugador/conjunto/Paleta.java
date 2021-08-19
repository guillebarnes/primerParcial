package domain.entities.jugador.conjunto;

public class Paleta extends Equipo{
    private String marca;
    private Forma forma;
    private int peso;

    public Paleta(String marca, Forma forma, int peso) {
        this.marca = marca;
        this.forma = forma;
        this.peso = peso;
    }
}
