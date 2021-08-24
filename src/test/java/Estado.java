import domain.entities.jugador.Jugador;
import domain.entities.jugador.estados.Cansado;
import domain.entities.jugador.estados.Descansado;
import domain.entities.jugador.estados.Lesionado;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class Estado {
    Jugador daniel = new Jugador("Daniel", "Alde", new Descansado());


    @Test
    public void testVariacionDeEnergia() throws Exception {

        //Cuando daniel juega disminuto su energia
        daniel.jugar();
        Assert.assertTrue(daniel.getEnergia() < 1);
        //Cuando daniel descansa mucho, por lo tanto... Su energia es 100 % pero no la supera
        daniel.descansar();
        daniel.descansar();
        daniel.descansar();
        daniel.descansar();
        daniel.descansar();
        daniel.descansar();
        Assert.assertEquals(0.9, daniel.getEnergia(), 0);
    }

    @Test
    public void testTransicionEstados() throws Exception {

        //Cuando daniel juega -> disminuye su energia pero no la suficiente como para pasar a cansado
        daniel.jugar();//85%
        Assert.assertTrue(daniel.getEstado() instanceof Descansado);

        //Cuando daniel juega varios partidos... se cansa
        daniel.jugar();//70%
        daniel.jugar();//55%
        daniel.jugar();//40%
        Assert.assertTrue(daniel.getEstado() instanceof Cansado);

        //Cuando daniel descansa -> pasa a estar descansado
        daniel.descansar();
        Assert.assertTrue(daniel.getEstado() instanceof Descansado);

        //si daniel esta cansado y se cansa bastante rapido... a pesar de descansar... sigue cansado
        daniel.setEstado(new Cansado());
        daniel.setLimiteCansancio(0.8);
        daniel.setEnergia(0.1);
        daniel.descansar();//0.25%
        Assert.assertTrue(daniel.getEstado() instanceof Cansado);

        //Si daniel esta full energia pero esta lesionado por 1 dia... por lo tanto... no puede jugar
        daniel.setEstado(new Lesionado(1, LocalDate.now(), "Se rompio"));
        daniel.setEnergia(1);
        try {
            daniel.jugar();
            Assert.fail();
        } catch (Exception e) {
            //Si daniel se lesiono hace uno semana atras y al descansar... se le pasa la lesion y puede jugar
            Lesionado lesion = (Lesionado) daniel.getEstado();
            lesion.setFechaLesion(LocalDate.now().minusDays(7));
            daniel.descansar();
            Assert.assertTrue(daniel.puedeJugar());
        }


    }
}
