package fr.esiea.ex4A.Controller;

import fr.esiea.ex4A.Agify.AgifyClient;
import fr.esiea.ex4A.Agify.AgifyUser;
import fr.esiea.ex4A.MatchesData;
import fr.esiea.ex4A.Service.AgifyService;
import fr.esiea.ex4A.Repository.UserRepository;
import fr.esiea.ex4A.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
class ApiController {

    private final UserRepository userRepository;
    private final AgifyClient client;
    private final AgifyService service;

    ApiController(UserRepository userRepository, AgifyClient client,AgifyService service) {

        this.userRepository = userRepository;
        this.client=client;
        this.service = service;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String addUser(@RequestBody Map<String,String> body){
        User user = new User(body.get("userName"), body.get("userMail"), body.get("userTwitter"), body.get("userCountry"), body.get("userSex"), body.get("userSexPref"));

        /*for (User userInList : userRepository.getUsers()){
            System.out.println(userInList.getUserName());
        }*/
        return "result : "+userRepository.addUser(user);

    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String match(@RequestParam(name = "userName" , required = true ) String userName,
                 @RequestParam(name = "userCountry", required = true) String userCountry) throws IOException{

        ObjectMapper mapper = new ObjectMapper();
        AgifyUser prime = service.getAge(userName, userCountry);
        List<MatchesData> matchesDataList = service.getMatches(prime.getAge());

        String matchResult = mapper.writeValueAsString(matchesDataList);
        return matchResult;
    }
}
