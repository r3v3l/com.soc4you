package services.userModel;

import repositories.userRepository.SearchByUserNameRepository;

/**
 * Created by adrian on 21.08.16.
 */
public class CheckUsernameService {

    public static boolean check(String username){

        if(SearchByUserNameRepository.searchByName(username) != null){

            return true;

        }

        return false;

    }

}
