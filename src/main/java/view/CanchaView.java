package view;

import domain.entities.club.Cancha;

import java.util.List;

public class CanchaView {
    public void ejecutar(List<Cancha> canchas){
        System.out.println("Seleccione una cancha: ");
        for(int i=0; i<canchas.size(); i++){
            System.out.println("--------------------");
            System.out.println("Cancha nro "+ i);
            System.out.println("Precio: "+ canchas.get(i).getPrecio());
            System.out.println("Es techada: " + this.techada(canchas.get(i)));
            //canchas.get(i).mostrarse();
        }
    }

    private String techada(Cancha cancha){
        if(cancha.esTechada())
            return "si";
        else
            return "no";
    }
}
