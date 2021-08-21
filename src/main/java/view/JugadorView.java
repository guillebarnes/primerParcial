package view;

import domain.dao.CanchaDAO;
import domain.entities.club.Cancha;
import domain.entities.club.Club;
import domain.entities.club.Reserva;
import domain.entities.club.VerificadorDeReserva;
import domain.entities.club.services.Online;
import domain.entities.club.services.Presencial;
import domain.entities.club.services.TipoDePago;
import domain.entities.jugador.Jugador;
import domain.entities.jugador.conjunto.Forma;
import domain.entities.jugador.conjunto.Paleta;
import domain.entities.jugador.estados.Disponible;
import domain.entities.jugador.estados.Lesionado;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class JugadorView {

    public void hacerUnaReserva(List<Jugador> jugadores, Club club) throws IOException {
        System.out.println("Ingrese una fecha (MM/DD/AAAA): ");
        Scanner ingresoFecha = new Scanner(System.in);
        String fecha = ingresoFecha.nextLine();
        System.out.println("Ingrese horario (HH:HH): ");
        Scanner ingresoHora = new Scanner(System.in);
        String hora = ingresoHora.nextLine();
        Date fechaReserva = new Date(fecha + ", " + hora );

        CanchaView canchaView = new CanchaView();
        canchaView.ejecutar(club.getCanchas());

        System.out.println("Ingrese el numero de cancha del club a la que desea reservar: ");
        Scanner ingresoCancha = new Scanner(System.in);
        int cancha = ingresoCancha.nextInt();
        Cancha canchaSeleccionada = club.getCanchas().get(cancha);


        System.out.println("Seleccione tipo de pago online (0) o presencial (1): ");
        Scanner ingresoTipoDePago = new Scanner(System.in);
        int tipoDePago = ingresoTipoDePago.nextInt();

        VerificadorDeReserva verificadorDeReserva = new VerificadorDeReserva();
        if(verificadorDeReserva.verificarReserva(jugadores, club, canchaSeleccionada)){
            club.recibirReserva(fechaReserva, club.getCanchas().get(cancha), jugadores, this.seleccionTipoPago(tipoDePago));
            System.out.println("La reserva se realizo con exito para el dia " + fechaReserva);
        }
        else
            System.out.println("La reserva no fue realizada porque se encontró un error");
    }

    public void cargarConjunto(Jugador jugador){

    }
    public void cargarPaleta(Jugador jugador){

        System.out.println("Ingrese marca de la paleta: ");
        Scanner marcaPaleta = new Scanner(System.in);
        String marcaIngresada = marcaPaleta.nextLine();

        System.out.println("Que forma tiene su paleta?");
        System.out.println("1) Redonda ");
        System.out.println("2) Diamante ");
        System.out.println("3) Gota ");
        Scanner formaPaleta = new Scanner(System.in);
        int formaIngresada = formaPaleta.nextInt();
        Forma forma = Forma.DIAMANTE;
        if(formaIngresada == 1)
            forma = Forma.REDONDA;
        if(formaIngresada == 2)
            forma = Forma.DIAMANTE;
        if(formaIngresada == 3)
            forma = Forma.GOTA;

        System.out.println("Indique cuanto pesa su paleta en grms (aprox)");
        Scanner pesoPaleta = new Scanner(System.in);
        int pesoIngresado = pesoPaleta.nextInt();

        Paleta oPaleta = new Paleta(marcaIngresada, forma , pesoIngresado);

        jugador.setConjunto(oPaleta);

        System.out.println("-------------------------------------------------");
        System.out.println("Su paleta " + marcaIngresada + " fue registrada!");
        System.out.println("-------------------------------------------------");
    }
    public void informarUnaLesion(Jugador jugador){
        Lesionado lesionado = new Lesionado();
        jugador.cambiarEstado(lesionado);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("El jugador " + jugador.getNombre() + " " + jugador.getApellido() + " se encuentra lesionado y no podra jugar.");
        System.out.println("---------------------------------------------------------------------------------------");
    }
    public void darAltaDeLesion(Jugador jugador){
        Disponible disponible = new Disponible();
        jugador.cambiarEstado(disponible);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("El jugador " + jugador.getNombre() + " " + jugador.getApellido() + " se recupero de su lesion y está disponible para jugar.");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private TipoDePago seleccionTipoPago(int seleccion){
        Online pagoOnline = new Online();
        Presencial pagoPresencial = new Presencial();
        if(seleccion == 0)
            return pagoOnline;
        else
            return pagoPresencial;
    }
    public void mostrarClubes(List<Club> clubes){
        for(int i=0; i<clubes.size(); i++){
            System.out.println("Club numero: " + clubes.get(i).getId());
            System.out.println("Ciudad: " + clubes.get(i).getUbicacion().getCiudad());
            System.out.println("Direccion: " + clubes.get(i).getUbicacion().getDireccion());
            System.out.println("----------------------------------------------------------");
        }
    }
}
