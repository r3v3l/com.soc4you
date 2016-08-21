package helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by adrian on 21.08.16.
 */
public class PasswordGenerator {

    public static String genPass( int chars ) {
        Random r = new Random();
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println( "Unsupported Algorithm!" );
            return null;
        }

        byte[] entropy = new byte[1024];
        r.nextBytes(entropy);
        md.update( entropy , 0, 1024 );

        return new BigInteger(1, md.digest()).toString(16).substring(0, chars);
    }

}