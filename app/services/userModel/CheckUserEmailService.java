package services.userModel;

import repositories.userRepository.SearchByEmailRepository;

/**
 * Created by adrian on 21.08.16.
 */
public class CheckUserEmailService {

    public static boolean check(String email){

        if(SearchByEmailRepository.searchByEmail(email) != null){

            return true;

        }

        return false;

    }

}
