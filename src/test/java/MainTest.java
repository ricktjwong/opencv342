import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class MainTest {
    @Test
    public void testHash() {
        InputStream imageStream = MainTest.class.getResourceAsStream("lena.png");
        Main main = new Main();
        String hash = main.generateHash(imageStream);
        Assert.assertTrue(hash.equals("152-99-43-180-174-196-101-105"));
    }
}
