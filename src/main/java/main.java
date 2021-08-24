import domain.dao.CanchaDAO;
import domain.dao.ClubDAO;
import domain.dao.ClubesDAO;
import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.jugador.Jugador;
import domain.entities.jugador.estados.Descansado;
import view.ClubView;
import view.JugadorView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {

        ClubDAO clubDAO = new ClubDAO();
        JugadorView jugadorView = new JugadorView();
        ClubView clubView = new ClubView();
        Jugador jugador1 = new Jugador("Fernando", "Belasteguin", new Descansado());
        Jugador jugador2 = new Jugador("Daniel", "Gutierrez", new Descansado());
        Jugador jugador3 = new Jugador("Franco", "Stupa", new Descansado());
        Jugador jugador4 = new Jugador("Juan Martin", "Diaz", new Descansado());
        Club club1 = clubDAO.select(3);
        List<Jugador> jugadores = new ArrayList<>();


        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);


        /*
        Se realiza el seteo de algunas variables para poder realizar pruebas de consola
        Ya que no esta implementada la funcionalidad de poder "invitar" jugadores a un partido
        */

        System.out.println("1) Probar como jugador");
        System.out.println("2) Probar como club");
        Scanner seleccion = new Scanner(System.in);

        switch (seleccion.nextInt()) {
            case 1:
                while (true) {
                    System.out.println("1) Realizar una reserva ");
                    System.out.println("2) Cargar conjunto (paleta, zapatillas, ropa) ");
                    System.out.println("3) Informar una lesion ");
                    System.out.println("4) Notificar Descanso ");/*Nueva funcion*/
                    System.out.println("5) Notificar Jugo Partido ");/*Nueva funcionalidad*/
                    Scanner seleccionJugador = new Scanner(System.in);
                    switch (seleccionJugador.nextInt()) {
                        case 1:
                            System.out.println("A que club desea hacer la reserva?");
                            ClubesDAO clubesBD = new ClubesDAO();
                            List<Club> clubes = clubesBD.select();
                            jugadorView.mostrarClubes(clubes);
                            Scanner ingresoDeClub = new Scanner(System.in);
                            Club clubSeleccionado = clubes.get(ingresoDeClub.nextInt());
                            CanchaDAO canchasDB = new CanchaDAO();
                            List<Cancha> canchas = canchasDB.select(clubSeleccionado.getId());
                            clubSeleccionado.setCanchas(canchas);
                            canchas.forEach(cancha -> {cancha.setClub(clubSeleccionado);});
                            jugadorView.hacerUnaReserva(jugadores, clubSeleccionado);
                            break;
                        case 2:
                            System.out.println("1) Cargar solamente paleta ");
                            System.out.println("2) Cargar conjunto ");
                            Scanner seleccionEquipo = new Scanner(System.in);
                            if (seleccionEquipo.nextInt() == 1)
                                jugadorView.cargarPaleta(jugador1);
                            else
                                jugadorView.cargarConjunto(jugador1);
                            break;
                        case 3:
                            /*TODO Agregar Scanner leyendo dias, fecha y descripcion*/
                            int diasReposo = 5;
                            LocalDate fecha = LocalDate.now();
                            String descripcionLesion = "Esguice de tobillo";
                            jugadorView.informarUnaLesion(jugador1, diasReposo, fecha, descripcionLesion);
                            break;
                        case 4:
                            //jugadorView.darAltaDeLesion(jugador1);
                            jugadorView.descansar(jugador1);
                            break;
                        case 5:
                            //jugadorView.darAltaDeLesion(jugador1);
                            jugadorView.jugar(jugador1);
                            break;
                    }
                }
            case 2:
                while (true) {
                    System.out.println("1)Agregar una cancha");
                    System.out.println("2)Listar mis canchas");
                    Scanner seleccionClub = new Scanner(System.in);
                    switch (seleccionClub.nextInt()) {
                        case 1:
                            clubView.agregarCancha(club1);
                            break;
                        case 2:
                            clubView.listarCanchas(club1);
                    }
                }
        }
    }


}
