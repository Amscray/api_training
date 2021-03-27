package fr.esiea.ex4A.Repository;
import fr.esiea.ex4A.Repository.UserRepository;
import fr.esiea.ex4A.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

    private final UserRepository userRepository = new UserRepository();


    @Test
    void getInscript()
    {
        Assertions.assertEquals(userRepository.getUsers().size(), 4 );
    }

    @Test
    void addUserTrue() {
        User user = new User("capucine", "caps@et.esiea.fr", "Dunii", "France", "M", "F");
        Assertions.assertTrue(userRepository.addUser(user));
    }
    @Test
    void addUserFalse()
    {
        User user =new User("capucine", "caps@et.esiea.fr", "Dunii", "France", "M", "F");
        userRepository.addUser(user);
        User user2 = new User("capucine", "caps@et.esiea.fr", "Dunii", "France", "M", "F");
        Assertions.assertFalse(userRepository.addUser(user));
    }


}
