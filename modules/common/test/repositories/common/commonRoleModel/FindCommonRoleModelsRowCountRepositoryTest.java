package repositories.common.commonRoleModel;

import org.junit.Test;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 23.08.16.
 */
public class FindCommonRoleModelsRowCountRepositoryTest {

    public int exceptedSize = 11;

    @Test
    public void rowCountTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertEquals(exceptedSize, rowCount());
        });

    }

    public int rowCount(){

        FindCommonRoleModelsRowCountRepository findCommonRoleModelsRowCountRepository =
                new FindCommonRoleModelsRowCountRepository();
        return findCommonRoleModelsRowCountRepository.rowCount();

    }

}