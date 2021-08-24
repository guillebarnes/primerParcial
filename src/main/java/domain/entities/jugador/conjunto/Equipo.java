package domain.entities.jugador.conjunto;

public class Equipo {
    protected String descripcion;

    public Equipo(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipo() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String descripcion() {
        return "Equipo: " + this.descripcion + " \n";
    }

    @Override
    public String toString() {
        return "Equipo: {" +
                "descripcion:'" + descripcion + '\'' +
                "}\n";
    }
}
