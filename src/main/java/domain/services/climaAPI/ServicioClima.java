package domain.services.climaAPI;

import domain.services.climaAPI.entities.Clima;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioClima {
    private static ServicioClima instancia = null;
    private Retrofit retrofit;
    private static final String urlAPI = "http://api.weatherbit.io/v2.0/";
    private String token = "2d56f11c34aa4ce595c6e520cf152bf3";

    private ServicioClima(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServicioClima getInstancia(){
        if(instancia == null)
            instancia = new ServicioClima();

        return instancia;
    }

    public Clima datosClima(int codigoPostal) throws IOException {
        ClimaService climaService = this.retrofit.create(ClimaService.class);

        Call<Clima> requestClima = climaService.climaSegunCodigoPostal(codigoPostal, token);
        Response<Clima> responseClima = requestClima.execute();

        return responseClima.body();
    }
}
