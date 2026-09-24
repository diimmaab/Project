package sk.upjs.paz;

import java.util.List;

public class UserService {
    private final List<User> database;

    public UserService(List<User> database) {
        this.database = database;
    }
    public GenderRatio computrGenderRatio(){
        double boys = 0.0;
        double girls = 0.0;
        double unknown = 0.0;

        for(User user : database){
            if(user.gender().equals(User.Gender.MALE)){
                boys++;
            }else if(user.gender().equals(User.Gender.FEMALE)){
                girls++;
            }else{
                unknown++;
            }
        }
        return new GenderRatio(boys,girls,unknown);
    }
}
