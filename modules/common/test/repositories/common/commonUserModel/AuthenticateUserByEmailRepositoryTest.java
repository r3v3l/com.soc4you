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
public class AuthenticateUserByEmailRepositoryTest {

    public String goodUserEmail = "r3v@protonmail.ch";
    public String goodUserPassword = "F@ntaSpr1te";
    public String badUserEmail = "rev@protonmail.pl";
    public String badUserPassword = "P3psiM@x1";

    @Test
    public void authenticate(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByEmail(goodUserEmail, goodUserPassword));
        });

    }

    @Test
    public void notAuthenticateBadEmail(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(findByEmail(badUserEmail, goodUserPassword));
        });

    }

    @Test
    public void notAuthenticateBadPassword(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(findByEmail(goodUserEmail, badUserPassword));
        });

    }

    public CommonUserModel findByEmail(String email, String passsword) {

        AuthenticateUserByEmailRepository authenticateUserByEmailRepository = new AuthenticateUserByEmailRepository();
        return authenticateUserByEmailRepository.findByEmail(email, passsword);

    }

}