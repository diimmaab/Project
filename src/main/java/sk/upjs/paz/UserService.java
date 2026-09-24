package sk.upjs.paz;

import java.util.List;

public class UserService {
    private final List<User> database;

    public UserService(List<User> database) {
        this.database = database;
    }
    public GenderRatio computrGenderRatio(){

        if (this.database == null ||  this.database.isEmpty()) {
            return new GenderRatio(0.0, 0.0, 0.0);
        }

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
        double sum = boys + girls + unknown;
        return new GenderRatio(boys / sum,girls / sum,unknown/ sum);
    }
}
