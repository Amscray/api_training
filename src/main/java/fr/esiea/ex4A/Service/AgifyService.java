package fr.esiea.ex4A.Service;


import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import fr.esiea.ex4A.MatchesData;
import fr.esiea.ex4A.User;
import fr.esiea.ex4A.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class AgifyService {

    private final AgifyClient client;

    private final UserRepository userRepository;

    private final Map<String, Integer> cache = new HashMap<>();

    public AgifyService(AgifyClient client, UserRepository userRepository) {
        this.client = client;
        this.userRepository = userRepository;
    }

    public AgifyUser getAge(String name, String country) throws IOException {
        return (AgifyUser) client.getAgeUser(name, country).execute().body();
    }

    public ArrayList<MatchesData> getMatches(int ageReference) throws IOException {
        ArrayList<MatchesData> matches = new ArrayList<MatchesData>();
        for (User match : userRepository.getUsers()) {
            AgifyUser matchFind = getAge(match.getUserName(), match.getUserCountry());
            if (matchFind.getAge() - ageReference <= 4 && matchFind.getAge() - ageReference >= -4) {

                matches.add(new MatchesData(match.getUserName(), match.getUserTweeter()));
            }
        }
        return matches;
    }
}
