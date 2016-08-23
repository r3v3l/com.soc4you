package repositories.common.commonStatusModel;

import models.common.CommonStatusModel;
import org.junit.Test;
import play.test.WithApplication;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 22.08.16.
 */
public class FindCommonStatusModelByStatusNameRepositoryTest extends WithApplication {

    public String activeStatusName = "active";
    public String inactiveStatusName = "inactive";
    public String frozenStatusName = "frozen";
    public String bannedStatusName = "banned";
    public String blockedStatusName = "blocked";
    public String offlineStatusName = "offline";
    public String onlineStatusName = "online";

    public String fakeStatusName = "fake";

    @Test
    public void findActiveStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(activeStatusName));
        });
    }

    @Test
    public void findInactiveStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(inactiveStatusName));
        });
    }

    @Test
    public void findFrozenStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(frozenStatusName));
        });
    }

    @Test
    public void findBannedStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(bannedStatusName));
        });
    }

    @Test
    public void findBlockedStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(blockedStatusName));
        });
    }

    @Test
    public void findOnlineStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(onlineStatusName));
        });
    }

    @Test
    public void findOfflineStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNotNull(findByName(offlineStatusName));
        });
    }

    @Test
    public void findFakeStatusTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertNull(findByName(fakeStatusName));
        });
    }

    public CommonStatusModel findByName(String statusName){

        FindCommonStatusModelByStatusNameRepository findCommonStatusModelByStatusName =
                new FindCommonStatusModelByStatusNameRepository();
        return findCommonStatusModelByStatusName.findByName(statusName);

    }

}