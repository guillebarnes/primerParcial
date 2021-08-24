package domain.entities.jugador;

import domain.entities.jugador.conjunto.Equipo;
import domain.entities.jugador.estados.Estado;
import domain.entities.jugador.estados.Lesionado;

public class Jugador {
    private String nombre;
    private String apellido;
    private Posicion posicion;
    private Equipo conjunto;
    private Estado estado;
    private double energia;
    private double limiteCansancio;

    /*TODO:Agregar energia*/

    public Jugador(String nombre, String apellido, Estado estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.energia = 1;
        this.limiteCansancio = 0.5;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean puedeJugar() {
        return this.estado.puedeJugar(this);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Equipo getConjunto() {
        return conjunto;
    }

    public void setConjunto(Equipo equipo) {
        this.conjunto = equipo;
    }

    public double getLimiteCansancio() {
        return limiteCansancio;
    }

    public void setLimiteCansancio(double limiteCansancio) {
        this.limiteCansancio = limiteCansancio;
    }

    //Funcionalidad
    public void aumentarEnergia(double cantidad) {
        this.energia += cantidad;
        this.energia = Math.min(this.energia, 1);
    }

    public void disminuirEnergia(double cantidad) {
        this.energia -= cantidad;
        this.energia = Math.max(this.energia, 0);
    }

    public void descansar() {
        this.estado.descanso(this);
    }

    public void jugar() throws Exception {
        this.estado.jugarPartido(this);
    }

    public void lesion(Lesionado lesionado) {
        this.estado = lesionado;
    }

    public boolean estaCansado() {
        return this.energia < this.limiteCansancio;
    }
}
