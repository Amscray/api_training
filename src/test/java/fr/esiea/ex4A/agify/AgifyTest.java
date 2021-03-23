package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

class AgifyTest {
    @Test
    AgifyUser AgifyUserTest() throws IOException {
        AgifyClient test = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> user = test.getAgeUser("Marine","FR");

        AgifyUser userFinal = user.execute().body();
        return userFinal;
    }

    @Test
    void getName() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("Marine",testUser.getName());

    }

    @Test
    void setName() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setName("Mangan");
        Assertions.assertEquals("Mangan",testUser.getName());
    }

    @Test
    void getAge() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(48,testUser.getAge());
    }

    @Test
    void setAge() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setAge(24);
        Assertions.assertEquals(24,testUser.getAge());
    }

    @Test
    void getCount() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals(24042,testUser.getCount());
    }

    @Test
    void setCount() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setCount(420);
        Assertions.assertEquals(420,testUser.getCount());
    }

    @Test
    void getCountryId() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        Assertions.assertEquals("FR",testUser.getCountryId());
    }

    @Test
    void setCountryId() throws IOException {
        AgifyUser testUser = AgifyUserTest();
        testUser.setCountryId("US");
        Assertions.assertEquals("US",testUser.getCountryId());
    }
}
