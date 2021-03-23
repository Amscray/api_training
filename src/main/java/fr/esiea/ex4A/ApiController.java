package fr.esiea.ex4A;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import fr.esiea.ex4A.UserRepository;
import fr.esiea.ex4A.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
class ApiController {

    private final UserRepository userRepository;

    ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    User addUser(@RequestBody Map<String,String> body){
        User user = new User(body.get("userName"), body.get("userMail"), body.get("userTwitter"), body.get("userCountry"), body.get("userSex"), body.get("userSexPref"));
        userRepository.addUser(user);
        for (User userInList : userRepository.getUsers()){
            System.out.println(userInList.getUserName());
        }
        return user;
    }

    @GetMapping(path = "/api/matches", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String match(@RequestParam(name = "userName" , required = true ) String userName,
                 @RequestParam(name = "userCountry", required = true) String userCountry) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        MatchesData match = new MatchesData("Lea","coucoumoi");
        MatchesData match2 = new MatchesData("Lea2","coucoumoi1");

        List<MatchesData> matchesDataList = new ArrayList<>();
        matchesDataList.add(match);
        matchesDataList.add(match2);
        String matchResult = mapper.writeValueAsString(matchesDataList);
        return matchResult;
    }
}
