package fr.esiea.ex4A;

import fr.esiea.ex4A.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> inscrit = new ArrayList<User>();

    public UserRepository() {
        User user1 = new User("Leo", "calis@et.esiea.fr", "Amscray", "FR", "M", "F");
        inscrit.add(user1);
        User user2 = new User("Marine", "mangan@et.esiea.fr", "MangueAne", "FR", "F", "M");
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

