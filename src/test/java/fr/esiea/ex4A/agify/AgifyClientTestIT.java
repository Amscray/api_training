package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


class AgifyClientTestIT {

    @Test
    void AgifyVerif() throws Exception {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> user = test.getAgeUser("leo", "FR");
        AgifyUser userFinal = user.execute().body();
        Assertions.assertEquals(53, userFinal.getAge());
        Assertions.assertEquals("FR", userFinal.getCountryId());
        Assertions.assertEquals(2567, userFinal.getCount());
        Assertions.assertEquals("leo", userFinal.getName());
    }
}
