import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testHash() {
        String imagePath = MainTest.class.getResource("lena.png").getPath();
        Main main = new Main();
        String hash = main.generateHash(imagePath);
        Assert.assertTrue(hash.equals("152-99-43-180-174-196-101-105"));
    }
}
