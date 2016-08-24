package repositories.common.commonUserModel;

import models.common.CommonUserModel;
import org.junit.Test;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 24.08.16.
 */
public class FindCommonUserModelByEmailRepositoryTest {

    public String userEmail = "r3v@protonmail.ch";
    public String fakeEmail = "fake@email.com";

    @Test
    public void findFakeEmailTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(find(fakeEmail));
        });

    }

    @Test
    public void findUserEmailTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(find(userEmail));
        });

    }

    public CommonUserModel find(String email){

        FindCommonUserModelByEmailRepository findCommonUserModelByEmailRepository =
                new FindCommonUserModelByEmailRepository();
        return findCommonUserModelByEmailRepository.find(email);
    }

}