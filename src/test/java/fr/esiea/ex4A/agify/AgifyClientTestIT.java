package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class AgifyClientTestIT {

@Test
    void AgifyTestVerif()throws Exception{
        AgifyClient client = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

    Call<AgifyUser> userTest = client.getAgeUser("Marine", "FR");
    AgifyUser user = userTest.execute().body();
    Assertions.assertEquals(28,  user.getAge());
    Assertions.assertEquals("FR",  user.getCountryId());
    Assertions.assertEquals(24042,  user.getCount());
    Assertions.assertEquals("Marine",  user.getName());

}

}
