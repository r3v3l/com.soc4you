package helpers.common;

import org.junit.Test;
import play.test.WithApplication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by adrian on 25.08.16.
 */
public class CommonEmailValidatorHelperTest extends WithApplication {

    public String firstGoodEmail = "me@email.com";
    public String secondGoodEmail = "me@email.co.uk";
    public String thirdGoodEmail = "me@yahoo.com";
    public String fourthGoodEmail = "me-100@email.com";
    public String fifthGoodEmail = "me.100@email.com";
    public String sixthGoodEmail = "me@e-mail.com";

    public String firstBadEmail = "me@.email.com";
    public String secondBadEmail = "me@.com";
    public String thirdBadEmail = "me@.com.com";
    public String fourthBadEmail = "me@%*email.com";
    public String fifthBadEmail = "me@me@email.com";
    public String sixthBadEmail = "me@email.com.1a";

    @Test
    public void firstGoodEmailTest(){

        assertTrue(validate(firstGoodEmail));

    }

    @Test
    public void secondGoodEmailTest(){

        assertTrue(validate(secondGoodEmail));

    }

    @Test
    public void thirdGoodEmailTest(){

        assertTrue(validate(thirdGoodEmail));

    }

    @Test
    public void fourthGoodEmailTest(){

        assertTrue(validate(fourthGoodEmail));

    }

    @Test
    public void fifthGoodEmailTest(){

        assertTrue(validate(fifthGoodEmail));

    }

    @Test
    public void sixthGoodEmailTest(){

        assertTrue(validate(sixthGoodEmail));

    }

    @Test
    public void firstBadEmailTest(){

        assertFalse(validate(firstBadEmail));

    }

    @Test
    public void secondBadEmailTest(){

        assertFalse(validate(secondBadEmail));

    }

    @Test
    public void thirdBadEmailTest(){

        assertFalse(validate(thirdBadEmail));

    }

    @Test
    public void fourthBadEmailTest(){

        assertFalse(validate(fourthBadEmail));

    }

    @Test
    public void fifthBadEmailTest(){

        assertFalse(validate(fifthBadEmail));

    }

    @Test
    public void sixthBadEmailTest(){

        assertFalse(validate(sixthBadEmail));

    }

    public boolean validate(String email){

        CommonEmailValidatorHelper commonEmailValidatorHelper = new CommonEmailValidatorHelper();
        return commonEmailValidatorHelper.isValidEmxailAddress(email);

    }

}
