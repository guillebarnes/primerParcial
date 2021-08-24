import domain.entities.jugador.conjunto.Conjunto;
import domain.entities.jugador.conjunto.Equipo;
import domain.entities.jugador.conjunto.Forma;
import domain.entities.jugador.conjunto.Paleta;
import org.junit.Assert;
import org.junit.Test;

public class EquipoTest {
    Equipo zapatilla = new Equipo("zapatillas");
    Equipo pantalon = new Equipo("pantalon");
    Paleta paleta = new Paleta("Paleta Roja", "Marca 1", Forma.DIAMANTE, 5);
    Conjunto conjuntoNike = new Conjunto("Nike");
    Conjunto conjuntoAdidas = new Conjunto("Adidas");
    Conjunto equipamiento = new Conjunto("equipo1");

    @Test
    public void testComponentesSeparados() {

        conjuntoNike.agregarEquipo(zapatilla);
        conjuntoNike.agregarEquipo(paleta);
        conjuntoAdidas.agregarEquipo(pantalon);

        equipamiento.agregarEquipo(conjuntoNike);
        equipamiento.agregarEquipo(conjuntoAdidas);


        System.out.println(equipamiento.descripcion());
        System.out.println("-----------------");
        System.out.println(equipamiento);

        Assert.assertNotNull(equipamiento.descripcion());


    }


}
