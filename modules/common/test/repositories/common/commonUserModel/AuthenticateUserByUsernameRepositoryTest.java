package repositories.common.commonUserModel;

import models.common.CommonUserModel;
import org.junit.Test;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 25.08.16.
 */
public class AuthenticateUserByUsernameRepositoryTest {

    public String goodUsername = "r3v";
    public String goodPassword = "F@ntaSpr1te";
    public String badUsername = "rev";
    public String badPassword = "FantaSprite";

    @Test
    public void authenticate(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByUserName(goodUsername, goodPassword));
        });
    }

    @Test
    public void notAuthenticateByBadUsername(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(findByUserName(badUsername, goodPassword));
        });
    }

    @Test
    public void notAuthenticateByBadPassword(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(findByUserName(goodUsername, badPassword));
        });
    }

    public CommonUserModel findByUserName(String username, String password) {

        AuthenticateUserByUsernameRepository authenticateUserByUsernameRepository =
                new AuthenticateUserByUsernameRepository();
        return authenticateUserByUsernameRepository.findByUserName(username, password);

    }

}