package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getuName() {
        User user = new User("Michel", "michel@et.esiea.fr", "Michou", "FR", "M", "F");
        Assertions.assertEquals("Michel", user.getUserName());
    }

    @Test
    void getuMail() {
        User user = new User("Michel", "michel@et.esiea.fr", "Michou", "FR", "M", "F");
        Assertions.assertEquals("michel@et.esiea.fr", user.getUserMail());
    }

    @Test
    void getuTweeter() {
        User user = new User("Michel", "michel@et.esiea.fr", "Michou", "FR", "M", "F");
        Assertions.assertEquals("Michou", user.getUserTweeter());
    }

    @Test
    void getuCountry() {
        User user = new User("Michel", "michel@et.esiea.fr", "Michou", "FR", "M", "F");
        Assertions.assertEquals("FR", user.getUserCountry());
    }

    @Test
    void getuSex() {
        User user = new User("Michel", "michel@et.esiea.fr", "Michou", "FR", "M", "F");
        Assertions.assertEquals("M", user.getUserSex());
    }

    @Test
    void getuSexPref() {
        User user = new User("Michel", "michel@et.esiea.fr", "Michou", "FR", "M", "F");
        Assertions.assertEquals("F", user.getUserSexPref());
    }
}
