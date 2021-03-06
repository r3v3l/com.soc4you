package repositories.common.commonStatusModel;

import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.*;

/**
 * Created by adrian on 22.08.16.
 */
public class FindCommonStatusModelsRowCountRepositoryTest extends WithApplication {

    public int exceptedSize = 7;

    @Test
    public void rowCountTest() {

        running(fakeApplication(inMemoryDatabase("test")), () -> {

            assertEquals(exceptedSize, rowCount());

        });

    }

    public int rowCount()  {

        FindCommonStatusModelsRowCountRepository findCommonStatusModelsRowCount =
                new FindCommonStatusModelsRowCountRepository();
        return findCommonStatusModelsRowCount.rowCount();

    }

}