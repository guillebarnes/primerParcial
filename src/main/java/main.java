import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.club.Ubicacion;
import domain.entities.jugador.Jugador;
import domain.entities.jugador.estados.Disponible;
import view.JugadorView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        
        JugadorView vistaJugador = new JugadorView();
        Disponible disponible = new Disponible();

        Jugador jugador1 = new Jugador("Fernando", "Belasteguin", disponible);
        Jugador jugador2 = new Jugador("Daniel", "Gutierrez", disponible);
        Jugador jugador3 = new Jugador("Franco", "Stupa", disponible);
        Jugador jugador4 = new Jugador("Juan Martin", "Diaz", disponible);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);

        Club club = new Club();
        Ubicacion ubicacionClub = new Ubicacion("Buenos Aires", "Moreno", "Guatemala 6681", 1744);
        club.setUbicacion(ubicacionClub);
        Cancha cancha1 = new Cancha(false, 500);
        Cancha cancha2 = new Cancha(true,700);
        club.agregarCancha(cancha1);
        club.agregarCancha(cancha2);

        /*
        Se realiza el seteo de algunas variables para poder realizar pruebas de consola.
        Lo más óptimo sería traerse estas variables desde base de datos.


        System.out.println("1) Ingresar como jugador");
        System.out.println("2) Ingresar como club");
        Scanner seleccion = new Scanner(System.in);

        switch (seleccion.nextInt()){
            case 1:
                while(true){
                    System.out.println("1) Realizar una reserva ");
                    System.out.println("2) Cargar conjunto (paleta, zapatillas, ropa) ");
                    System.out.println("3) Informar una lesion ");
                    System.out.println("4) Dar de alta una lesion ");
                    Scanner seleccionJugador = new Scanner(System.in);
                    switch (seleccionJugador.nextInt()) {
                        case 1:
                            vistaJugador.hacerUnaReserva(jugadores, club);
                            break;
                        case 2:
                            System.out.println("1) Cargar solamente paleta ");
                            System.out.println("2) Cargar conjunto ");
                            Scanner seleccionEquipo = new Scanner(System.in);
                            if(seleccionEquipo.nextInt() == 1) {
                                vistaJugador.cargarPaleta(jugador1);
                                System.out.println("hola");
                            }
                            if(seleccionEquipo.nextInt() == 2)
                                vistaJugador.cargarConjunto(jugador1);
                            break;
                        case 3:
                            vistaJugador.informarUnaLesion(jugador1);
                            break;
                        case 4:
                            vistaJugador.darAltaDeLesion(jugador1);
                            break;
                    }
                }
        }
*/

    }
}
