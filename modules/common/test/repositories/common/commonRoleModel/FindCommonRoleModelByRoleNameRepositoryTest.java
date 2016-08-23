package repositories.common.commonRoleModel;

import models.common.CommonRoleModel;
import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 23.08.16.
 */
public class FindCommonRoleModelByRoleNameRepositoryTest extends WithApplication {

    public String guestRoleName         = "guest";
    public String userRoleName          = "user";
    public String customerRoleName      = "customer";
    public String advertiserRoleName    = "advertiser";
    public String developerRoleName     = "developer";
    public String qaRoleName            = "qa";
    public String authorRoleName        = "author";
    public String editorRoleName        = "editor";
    public String moderatorRoleName     = "moderator";
    public String adminRoleName         = "admin";
    public String businessRoleName      = "business";

    public String fakeRoleName = "fake";

    @Test
    public void guestRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(guestRoleName));
        });
    }

    @Test
    public void userRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(userRoleName));
        });
    }

    @Test
    public void customerRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(customerRoleName));
        });
    }

    @Test
    public void advertiserRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(advertiserRoleName));
        });
    }

    @Test
    public void developerRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(developerRoleName));
        });
    }

    @Test
    public void qaRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(qaRoleName));
        });
    }

    @Test
    public void authorRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(authorRoleName));
        });
    }

    @Test
    public void editorRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(editorRoleName));
        });
    }

    @Test
    public void moderatorRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(moderatorRoleName));
        });
    }

    @Test
    public void adminRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(adminRoleName));
        });
    }

    @Test
    public void businessRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(businessRoleName));
        });
    }

    @Test
    public void fakeRoleNameTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(findByName(fakeRoleName));
        });
    }

    public CommonRoleModel findByName(String roleName){

        FindCommonRoleModelByRoleNameRepository findCommonRoleModelByRoleNameRepository =
                new FindCommonRoleModelByRoleNameRepository();
        return findCommonRoleModelByRoleNameRepository.findByName(roleName);

    }

}