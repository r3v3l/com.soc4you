package services.common.commonRoleModel;

import models.common.CommonRoleModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repositories.common.commonRoleModel.FindCommonRoleModelByRoleNameRepository;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 23.08.16.
 */
public class CreateCommonRoleModelServiceTest {

    public String newRoleName = "new";
    public String statusName = "active";

    @Before
    public void setUp() throws Exception {

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            FindCommonRoleModelByRoleNameRepository findCommonRoleModelByRoleNameRepository =
                    new FindCommonRoleModelByRoleNameRepository();
            CommonRoleModel commonRoleModel = findCommonRoleModelByRoleNameRepository.findByName(newRoleName);
            if(commonRoleModel != null){
                commonRoleModel.delete();
            }
        });

    }

    @After
    public void tearDown() throws Exception {

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            FindCommonRoleModelByRoleNameRepository findCommonRoleModelByRoleNameRepository =
                    new FindCommonRoleModelByRoleNameRepository();
            CommonRoleModel commonRoleModel = findCommonRoleModelByRoleNameRepository.findByName(newRoleName);
            if(commonRoleModel != null){
                commonRoleModel.delete();
            }
        });

    }

    @Test
    public void createNewRole(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertTrue(create(newRoleName, statusName));
        });
    }

    public boolean create(String roleName, String statusName) {

        CreateCommonRoleModelService createCommonRoleModelService = new CreateCommonRoleModelService();
        return createCommonRoleModelService.create(roleName, statusName);

    }

}