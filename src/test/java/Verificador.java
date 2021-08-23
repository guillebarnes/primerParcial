import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.club.Reserva;
import domain.entities.club.Ubicacion;
import domain.entities.jugador.Jugador;
import domain.entities.jugador.estados.Descansado;
import domain.validador.CriterioClima;
import domain.validador.CriterioEstadoJugadores;
import domain.validador.CriterioMinimoJugador;
import domain.validador.ValidadorReserva;
import domain.validador.climaAPI.ServicioSiempreDespejado;
import domain.validador.climaAPI.ServicioSiempreLlueve;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Verificador {
    Reserva reserva = new Reserva();
    List<Jugador> jugadores = new ArrayList<>();
    CriterioMinimoJugador criterioMinimoJugador = new CriterioMinimoJugador(4);
    CriterioClima criterioClima = new CriterioClima(new ServicioSiempreLlueve());

    Ubicacion ubicacionClub = new Ubicacion("Buenos Aires", "Moreno", "Guatemala 6681", 1744);
    Club club = new Club(ubicacionClub);

    Jugador jugador1 = new Jugador("Guillermo", "Barnes", new Descansado());
    Jugador jugador2 = new Jugador("Guillermo", "Barnes", new Descansado());
    Jugador jugador3 = new Jugador("Guillermo", "Barnes", new Descansado());
    Jugador jugador4 = new Jugador("Guillermo", "Barnes", new Descansado());

    @Test
    public void cuatroJugadoresPuedenReservar() {

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        reserva.setJugadores(jugadores);

        Assert.assertTrue(criterioMinimoJugador.esValida(reserva));
    }

    @Test
    public void testCriterioClima() throws IOException {

        //Cancha techada
        Cancha cancha1 = new Cancha(true, 500, club);

        club.agregarCancha(cancha1);
        reserva.setCancha(cancha1);

        Assert.assertTrue(criterioClima.esValida(reserva));

        //Cancha si no esta techada, el encargado es el servicio
        cancha1.setTechada(false);
        Assert.assertFalse(criterioClima.esValida(reserva));

        //Cancha si se cambia el servicio a siempre despejado es siempre jugable
        criterioClima.setServicioClima(new ServicioSiempreDespejado());
        Assert.assertTrue(criterioClima.esValida(reserva));


    }

    @Test
    public void verificarReservaEntera() throws IOException {
        Cancha cancha1 = new Cancha(true, 500, club);

        ValidadorReserva validador = new ValidadorReserva();
        validador.agregarCriterio(criterioClima);
        validador.agregarCriterio(criterioMinimoJugador);
        validador.agregarCriterio(new CriterioEstadoJugadores());


        club.agregarCancha(cancha1);
        reserva.setCancha(cancha1);

        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        reserva.setJugadores(jugadores);

        Assert.assertTrue(validador.valida(reserva));
    }

}
