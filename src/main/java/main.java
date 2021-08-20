import domain.dao.CanchaDAO;
import domain.dao.ClubesDAO;
import domain.dao.Conexion;
import domain.dao.UbicacionDAO;
import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.club.Ubicacion;
import domain.entities.jugador.Jugador;
import domain.entities.jugador.estados.Disponible;
import view.CanchaView;
import view.JugadorView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
/*
        ClubesDAO clubesBD = new ClubesDAO();
        List<Club> clubes = clubesBD.select();

        JugadorView jugadorView = new JugadorView();
        jugadorView.mostrarClubes(clubes);

        CanchaDAO canchasDB = new CanchaDAO();
        List<Cancha> canchas = canchasDB.select(2);

        CanchaView canchaView = new CanchaView();
        canchaView.ejecutar(canchas);





 */
        Disponible disponible = new Disponible();
        JugadorView jugadorView = new JugadorView();
        Jugador jugador1 = new Jugador("Fernando", "Belasteguin", disponible);
        Jugador jugador2 = new Jugador("Daniel", "Gutierrez", disponible);
        Jugador jugador3 = new Jugador("Franco", "Stupa", disponible);
        Jugador jugador4 = new Jugador("Juan Martin", "Diaz", disponible);
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
                            if(seleccionEquipo.nextInt() == 1) {
                                jugadorView.cargarPaleta(jugador1);
                                System.out.println("hola");
                            }
                            if(seleccionEquipo.nextInt() == 2)
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
        }


    }
}
