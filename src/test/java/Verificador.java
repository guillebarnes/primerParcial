import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.club.Ubicacion;
import domain.entities.club.VerificadorDeReserva;
import domain.entities.jugador.Jugador;
import domain.entities.jugador.estados.Disponible;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*public class Verificador {

    @Test
    public void cuatroJugadoresPuedenReservar(){
        VerificadorDeReserva verificador = new VerificadorDeReserva();
        Disponible disponible = new Disponible();
        Jugador jugador1 = new Jugador("Guillermo", "Barnes", disponible);
        Jugador jugador2 = new Jugador("Guillermo", "Barnes", disponible);
        Jugador jugador3 = new Jugador("Guillermo", "Barnes", disponible);
        Jugador jugador4 = new Jugador("Guillermo", "Barnes", disponible);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        Assert.assertTrue(verificador.verificarJugadores(jugadores));
    }

    @Test
    public void unLugarConBuenTiempoPuedeRecibirReserva() throws IOException {
        VerificadorDeReserva verificador = new VerificadorDeReserva();
        Ubicacion ubicacionClub = new Ubicacion("Buenos Aires", "Moreno", "Guatemala 6681", 1744);
        Club club = new Club();
        Cancha cancha1 = new Cancha(false, 500);
        club.setUbicacion(ubicacionClub);
        club.agregarCancha(cancha1);
        Assert.assertTrue(verificador.hayBuenTiempo(club));
    }

    @Test
    public void verificarReservaEntera() throws IOException {
        VerificadorDeReserva verificador = new VerificadorDeReserva();
        Ubicacion ubicacionClub = new Ubicacion("Buenos Aires", "Moreno", "Guatemala 6681", 1744);
        Club club = new Club();
        Cancha cancha1 = new Cancha(false, 500);
        club.setUbicacion(ubicacionClub);
        club.agregarCancha(cancha1);
        Disponible disponible = new Disponible();
        Jugador jugador1 = new Jugador("Guillermo", "Barnes", disponible);
        Jugador jugador2 = new Jugador("Guillermo", "Barnes", disponible);
        Jugador jugador3 = new Jugador("Guillermo", "Barnes", disponible);
        Jugador jugador4 = new Jugador("Guillermo", "Barnes", disponible);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        Assert.assertTrue(verificador.verificarReserva(jugadores, club, club.getCanchas().get(0)));
    }

}
*/