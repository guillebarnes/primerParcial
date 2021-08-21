import domain.dao.*;
import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.club.Ubicacion;
import domain.entities.jugador.Jugador;
import domain.entities.jugador.estados.Disponible;
import view.CanchaView;
import view.ClubView;
import view.JugadorView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        ClubDAO clubDAO = new ClubDAO();
        Disponible disponible = new Disponible();
        JugadorView jugadorView = new JugadorView();
        ClubView clubView = new ClubView();
        Jugador jugador1 = new Jugador("Fernando", "Belasteguin", disponible);
        Jugador jugador2 = new Jugador("Daniel", "Gutierrez", disponible);
        Jugador jugador3 = new Jugador("Franco", "Stupa", disponible);
        Jugador jugador4 = new Jugador("Juan Martin", "Diaz", disponible);
        Club club1 = clubDAO.select(1);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);


        /*
        Se realiza el seteo de algunas variables para poder realizar pruebas de consola
        Ya que no esta implementada la funcionalidad de poder "invitar" jugadores a un partido
        */

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
                            System.out.println("A que club desea hacer la reserva?");
                            ClubesDAO clubesBD = new ClubesDAO();
                            List<Club> clubes = clubesBD.select();
                            jugadorView.mostrarClubes(clubes);
                            Scanner ingresoDeClub = new Scanner(System.in);
                            Club clubSeleccionado = clubes.get(ingresoDeClub.nextInt());
                            CanchaDAO canchasDB = new CanchaDAO();
                            List<Cancha> canchas = canchasDB.select(clubSeleccionado.getId());
                            clubSeleccionado.setCanchas(canchas);
                            jugadorView.hacerUnaReserva(jugadores, clubSeleccionado);
                            break;
                        case 2:
                            System.out.println("1) Cargar solamente paleta ");
                            System.out.println("2) Cargar conjunto ");
                            Scanner seleccionEquipo = new Scanner(System.in);
                            if(seleccionEquipo.nextInt() == 1)
                                jugadorView.cargarPaleta(jugador1);
                            else
                                jugadorView.cargarConjunto(jugador1);
                            break;
                        case 3:
                            jugadorView.informarUnaLesion(jugador1);
                            break;
                        case 4:
                            jugadorView.darAltaDeLesion(jugador1);
                            break;
                    }
                }
            case 2:
                while(true){
                    System.out.println("1)Agregar una cancha");
                    System.out.println("2)Listar mis canchas");
                    Scanner seleccionClub = new Scanner(System.in);
                    switch (seleccionClub.nextInt()){
                        case 1:
                            clubView.agregarCancha(club1);
                    }
                }

        }


    }
}
