package domain.entities.jugador;

import domain.entities.jugador.conjunto.Equipo;
import domain.entities.jugador.estados.Estado;

public class Jugador {
    private String nombre;
    private String apellido;
    private Posicion posicion;
    private Equipo conjunto;
    private Estado estado;
    private double energia;

    /*TODO:Agregar energia*/
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

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setConjunto(Equipo equipo) {
        this.conjunto = equipo;
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean puedeJugar() {
        return this.estado.puedeJugar(this);
    }

    //Funcionalidad
    public void aumentarEnergia(double cantidad) {
        this.energia += Math.min(cantidad, 1);
    }

    public void disminuirEnergia(double cantidad) {
        this.energia -= Math.max(cantidad, 0);
    }

    public void descansar() {
        this.estado.descanso(this);
    }

    public void jugar() {
        this.estado.jugarPartido(this);
    }
}
