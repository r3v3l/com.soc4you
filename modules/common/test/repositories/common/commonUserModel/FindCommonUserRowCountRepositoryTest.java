package repositories.common.commonUserModel;

import org.junit.Test;

import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

/**
 * Created by adrian on 24.08.16.
 */
public class FindCommonUserRowCountRepositoryTest {

    public int exceptedResult = 1;

    @Test
    public void rowCountTest(){

        running(fakeApplication(inMemoryDatabase("test")), () -> {
            assertEquals(exceptedResult, rowCount());
        });

    }

    public int rowCount() {

        FindCommonUserRowCountRepository findCommonUserRowCountRepository = new FindCommonUserRowCountRepository();
        return findCommonUserRowCountRepository.rowCount();

    }

}