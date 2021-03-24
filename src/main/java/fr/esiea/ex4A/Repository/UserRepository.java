package fr.esiea.ex4A.Repository;

import fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> inscrit = new ArrayList<User>();

    public UserRepository() {
        User user1 = new User("Leo", "calis@et.esiea.fr", "Amscray", "FR", "M", "F");
        inscrit.add(user1);
        User user2 = new User("Marine", "mangan@et.esiea.fr", "MangueAne", "FR", "F", "M");
        inscrit.add(user2);
        User user3 = new User("Martin", "Martin@et.esiea.fr", "Lyphazphea", "FR", "M", "F");
        inscrit.add(user1);
        User user4 = new User("Chloe", "Chloe@et.esiea.fr", "chlochlo", "FR", "F", "M");
        inscrit.add(user2);
        User user5 = new User("David", "David@et.esiea.fr", "Davidou", "FR", "M", "F");
        inscrit.add(user1);
        User user6 = new User("Capucine", "Capucine@et.esiea.fr", "Duniii", "FR", "F", "M");
        inscrit.add(user2);
    }


    public List<User> getUsers(){
        return this.inscrit;
    }

    public boolean addUser(User userAdd){
        for (User user : inscrit){
            if (user.getUserMail().equals(userAdd.getUserMail())){
                return false;
            }
        }
        inscrit.add(userAdd);
        return true;
    }
}

