package domain.entities.jugador.conjunto;

import java.util.ArrayList;
import java.util.List;

public class Conjunto extends Equipo {
    private List<Equipo> conjuntoDeEquipo = new ArrayList<>();

    public Conjunto(String descripcion) {
        super(descripcion);
    }

    public Conjunto(String descripcion, List<Equipo> conjuntoDeEquipo) {
        this.conjuntoDeEquipo = conjuntoDeEquipo;
    }

    public List<Equipo> getConjuntoDeEquipo() {
        return conjuntoDeEquipo;
    }

    public void setConjuntoDeEquipo(List<Equipo> conjuntoDeEquipo) {
        this.conjuntoDeEquipo = conjuntoDeEquipo;
    }

    //Funcionalidad
    public void agregarEquipo(Equipo equipo) {
        this.conjuntoDeEquipo.add(equipo);
    }

    public void quitarEquipo(Equipo equipo) {
        this.conjuntoDeEquipo.remove(equipo);
    }

    @Override
    public String descripcion() {

        return "Conjunto " + this.descripcion + ": \n" + "\t" + obtenerDescripciones();
    }

    private String obtenerDescripciones() {
        return this.conjuntoDeEquipo.stream()
                .map(Equipo::descripcion)
                .reduce("\t", (s, s2) -> s + s2);
    }

    @Override
    public String toString() {
        return "Conjunto:{" +
                "conjuntoDeEquipo:" + conjuntoDeEquipo +
                "}\n";
    }
}
