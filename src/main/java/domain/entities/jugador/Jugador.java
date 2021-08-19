package domain.entities.jugador;

import domain.entities.jugador.conjunto.Equipo;
import domain.entities.jugador.estados.Estado;

public class Jugador {
    private String nombre;
    private String apellido;
    private Posicion posicion;
    private Equipo conjunto;
    private Estado estado;


    public Jugador(String nombre, String apellido, Estado estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setConjunto(Equipo equipo){
        this.conjunto = equipo;
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    public boolean puedeJugar() {
        return this.estado.puedeJugar();
    }
}
