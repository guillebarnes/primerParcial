package domain.validador.climaAPI;

import domain.entities.club.Ubicacion;
import domain.validador.AdapterClima;
import domain.validador.climaAPI.entities.Clima;
import domain.validador.climaAPI.entities.Weather;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioClimaWeatherbit implements AdapterClima {
    private static final String urlAPI = "http://api.weatherbit.io/v2.0/";
    private static ServicioClimaWeatherbit instancia = null;
    private final int TORMENTAS = 700;
    private final int PRECIPITACIONES = 900;
    private Retrofit retrofit;
    private String token = "ebc49a0ffb924ba6b9882a405ddc6390";

    private ServicioClimaWeatherbit() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioClimaWeatherbit getInstancia() {
        if (instancia == null)
            instancia = new ServicioClimaWeatherbit();

        return instancia;
    }

    public Clima datosClima(int codigoPostal) throws IOException {
        ClimaService climaService = this.retrofit.create(ClimaService.class);

        Call<Clima> requestClima = climaService.climaSegunCodigoPostal(codigoPostal, token);
        Response<Clima> responseClima = requestClima.execute();

        return responseClima.body();
    }

    @Override
    public boolean noLlueveEn(Ubicacion ubicacion) {
        ServicioClimaWeatherbit servicioClima = ServicioClimaWeatherbit.getInstancia();
        int codigoPostalClub = ubicacion.getCodigoPostal();
        Weather clima = null;
        try {
            clima = servicioClima.datosClima(codigoPostalClub).data.get(0).weather;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return clima.code >= TORMENTAS && clima.code != PRECIPITACIONES;

    }
}
