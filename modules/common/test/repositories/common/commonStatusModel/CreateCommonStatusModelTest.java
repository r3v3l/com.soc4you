package repositories.common.commonStatusModel;

import models.common.CommonStatusModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 22.08.16.
 */
public class CreateCommonStatusModelTest {

    public String existsStatus = "active";
    public String newStatus = "newStatus";
    public String nullStatus = "";

    @Before
    public void setUp() throws Exception {

        running(fakeApplication(inMemoryDatabase("test")), () -> {

            FindCommonStatusModelByStatusName findCommonStatusModelByStatusName =
                    new FindCommonStatusModelByStatusName();
            CommonStatusModel commonStatusModel = findCommonStatusModelByStatusName.findByName(newStatus);
            if(commonStatusModel != null){
                commonStatusModel.delete();
            }

        });

    }

    @Test
    public void nullStatusNameTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertFalse(create(nullStatus));
        });

    }

    @Test
    public void existsStatusNameTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertFalse(create(existsStatus));
        });

    }

    @Test
    public void newStatusNameTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertTrue(create(newStatus));
        });

    }

    public boolean create(String statusName) {

        CreateCommonStatusModel createCommonStatusModel = new CreateCommonStatusModel();
        return createCommonStatusModel.create(statusName);

    }

    @After
    public void tearDown() throws Exception {

        running(fakeApplication(inMemoryDatabase("test")), () -> {

            FindCommonStatusModelByStatusName findCommonStatusModelByStatusName =
                    new FindCommonStatusModelByStatusName();
            CommonStatusModel commonStatusModel = findCommonStatusModelByStatusName.findByName(newStatus);
            if(commonStatusModel != null){
                commonStatusModel.delete();
            }

        });

    }
}