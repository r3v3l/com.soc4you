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
public class FindCommonUserModelByUsernameRepositoryTest {

    public String username = "r3v";
    public String fakeUsername = "fake";

    @Test
    public void findUserByFakeUsernameTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(find(fakeUsername));
        });

    }

    @Test
    public void findUserByUsernameTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(find(username));
        });

    }

    public CommonUserModel find(String username) {

        FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                new FindCommonUserModelByUsernameRepository();
        return findCommonUserModelByUsernameRepository.find(username);

    }

}