package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Map;


class AgifyClientTestIT {

    @Test
    void AgifyVerif() throws Exception {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("http://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<Map<String, String>> user = test.getAgeUser("leo", "FR");
        Map<String, String> userFinal = user.execute().body();
        AgifyUser usertest = new AgifyUser(userFinal.get("name"),Integer.parseInt(userFinal.get("age")),Integer.parseInt(userFinal.get("count")), userFinal.get("country_id"));
        Assertions.assertEquals(53, usertest.getAge());
        Assertions.assertEquals("FR", usertest.getCountryId());
        Assertions.assertEquals(2567, usertest.getCount());
        Assertions.assertEquals("leo", usertest.getName());
    }
}
