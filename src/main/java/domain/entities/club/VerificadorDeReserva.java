package domain.entities.club;

import domain.entities.jugador.Jugador;
import domain.services.climaAPI.ServicioClima;
import domain.services.climaAPI.entities.Weather;

import java.io.IOException;
import java.util.List;

public class VerificadorDeReserva {

    public boolean verificarReserva(List<Jugador> jugadores, Club club, Cancha cancha) throws IOException {
        boolean esReservaValida = false;

        if(this.verificarJugadores(jugadores)){
            if(!cancha.esTechada()) {
                if (this.hayBuenTiempo(club))
                    esReservaValida = true;
            }
            else{
                esReservaValida = true;
                }
        }


        return esReservaValida;
    }

    public boolean verificarJugadores(List<Jugador> jugadores){
        return jugadores.size() >= 4 && jugadores.stream().allMatch(jugador -> jugador.puedeJugar());
    }

    /*
    Los codigos del clima pueden verse en la documentación de la API.
    Todos los códigos menores a 700 corresponden a tormentas, ya sea lluvia o nieve
    El código 900 corresponde a posibles precipitaciones.
     */
    public boolean hayBuenTiempo(Club club) throws IOException {
        ServicioClima servicioClima = ServicioClima.getInstancia();
        int codigoPostalClub = club.getUbicacion().getCodigoPostal();
        Weather clima = servicioClima.datosClima(codigoPostalClub).data.get(0).weather;

        return clima.code >= 700 && clima.code != 900;
    }
}
