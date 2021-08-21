package view;

import domain.entities.club.Cancha;
import domain.entities.club.Club;

import java.util.Scanner;

public class ClubView {

    public void agregarCancha(Club club) {
        System.out.println("Ingrese si la cancha es techada: ");
        System.out.println("1) Techada");
        System.out.println("2) Al aire libre");
        Scanner seleccionCancha = new Scanner(System.in);

        boolean esTechada = true;
        if(seleccionCancha.nextInt() == 2)
            esTechada = false;

        System.out.println("Ingrese cuando cuesta por hora la cancha: ");
        Scanner precioIngresado = new Scanner(System.in);

        double precio = precioIngresado.nextDouble();

        club.agregarCancha(esTechada, precio);
    }
}
