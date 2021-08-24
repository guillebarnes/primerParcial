package domain.entities.jugador.conjunto;

public class Paleta extends Equipo {
    private String marca;
    private Forma forma;
    private int peso;

    public Paleta(String descripcion, String marca, Forma forma, int peso) {
        super(descripcion);
        this.marca = marca;
        this.forma = forma;
        this.peso = peso;
    }

    public Paleta(String marca, Forma forma, int peso) {
        this.marca = marca;
        this.forma = forma;
        this.peso = peso;
    }

    @Override
    public String descripcion() {
        return "Paleta: " + this.descripcion + " " + this.marca + " " + this.forma + " " + this.peso + "\n";
    }

    @Override
    public String toString() {
        return "Paleta:{" +
                "marca:'" + marca + '\'' +
                ", forma:" + forma +
                ", peso:" + peso +
                "}\n";
    }
}
