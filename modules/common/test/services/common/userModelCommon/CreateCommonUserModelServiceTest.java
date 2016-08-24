package services.common.userModelCommon;

import models.common.CommonUserModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repositories.common.commonUserModel.FindCommonUserModelByUsernameRepository;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 24.08.16.
 */
public class CreateCommonUserModelServiceTest {

    public String username = "abc";
    public String email = "abc@protonmail.ch";
    public String password = "F@ntaSpr1te";
    public String statusName = "active";
    public String roleName = "admin";

    public String existsUsername = "r3v";
    public String existsEmail = "r3v@protonmail.ch";
    public String notExistsRole = "super_boss";
    public String notExistsStatus = "super";

    @Test
    public void createCommonUserModelUsernameExistsTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertFalse(create(existsUsername, email, password, statusName, roleName));
        });
    }

    @Test
    public void createCommonUserModelEmailExistsTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertFalse(create(username, existsEmail, password, statusName, roleName));
        });
    }

    @Test
    public void createCommonUserModelStatusNotExistsTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertFalse(create(username, email, password, notExistsStatus, roleName));
        });
    }

    @Test
    public void createCommonUserModelNotExistsRoleTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertFalse(create(username, email, password, statusName, notExistsRole));
        });
    }

    @Test
    public void createCommonUserModelServiceTest(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertTrue(create(username, email, password, statusName, roleName));
        });
    }

    @Before
    public void setUp(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                    new FindCommonUserModelByUsernameRepository();
            CommonUserModel commonUserModel = findCommonUserModelByUsernameRepository.find(username);
            if(commonUserModel != null){
                commonUserModel.delete();
            }
        });
    }

    @After
    public void tearDown(){
        running(fakeApplication(inMemoryDatabase("test")), () -> {
            FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                    new FindCommonUserModelByUsernameRepository();
            CommonUserModel commonUserModel = findCommonUserModelByUsernameRepository.find(username);
            if(commonUserModel != null){
                commonUserModel.delete();
            }
        });
    }

    public boolean create(String username, String email, String password, String userStatus, String userRole) {
        CreateCommonUserModelService createCommonUserModelService = new CreateCommonUserModelService();
        return createCommonUserModelService.create(username, email, password, userStatus, userRole);
    }

}