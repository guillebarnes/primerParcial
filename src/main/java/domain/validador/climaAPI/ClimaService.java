package domain.validador.climaAPI;

import domain.validador.climaAPI.entities.Clima;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClimaService {
    @GET("current")
    Call<Clima> climaSegunCodigoPostal(@Query("postal_code") int codigo_postal, @Query("key") String key);
}
