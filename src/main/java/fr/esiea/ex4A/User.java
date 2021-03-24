package fr.esiea.ex4A;
public class User {

    private final  String userEmail;
    private final  String userName;
    private final  String userTweeter;
    private final  String userCountry;
    private final  String userSex;
    private final  String userSexPref;

    public User(String userName, String userMail, String userTweeter, String userCountry, String userSex, String userSexPref){
        this.userName = userName;
        this.userEmail = userMail;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
    }
    public String getUserMail() {
        return userEmail;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserTweeter() {
        return userTweeter;
    }
    public String getUserCountry() {
        return userCountry;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserSexPref() {
        return userSexPref;
    }

}
