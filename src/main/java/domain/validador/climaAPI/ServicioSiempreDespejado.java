package domain.validador.climaAPI;

import domain.entities.club.Ubicacion;
import domain.validador.AdapterClima;

public class ServicioSiempreDespejado implements AdapterClima {

    @Override
    public boolean noLlueveEn(Ubicacion ubicacion) {
        return true;
    }
}
