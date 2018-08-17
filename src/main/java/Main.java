import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.img_hash.Img_hash;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public String generateHash(InputStream imageStream) {

        try {
            BufferedImage bufferedImage = ImageIO.read(imageStream);
            byte[] pixels = ((DataBufferByte) bufferedImage.getRaster().getDataBuffer()).getData();
            Mat sourceMat = new Mat(bufferedImage.getHeight(), bufferedImage.getWidth(), CvType.CV_8UC3);
            Mat destinationMat = new Mat(bufferedImage.getHeight(), bufferedImage.getWidth(), CvType.CV_8UC3);
            sourceMat.put(0, 0, pixels);
            Img_hash.pHash(sourceMat, destinationMat);

            System.out.println("OpenCV Mat data:\n" + destinationMat.dump());

            String[] elements = destinationMat.dump()
                    .replaceAll("\\[", "")
                    .replaceAll("\\]","")
                    .replaceAll(" ","")
                    .split(",");

            String hash = String.join("-", elements);
            System.out.println(hash);

            return hash;
        }catch(IOException e){
            return e.getMessage();
        }


    }

    public static void main(String[] args) {
        InputStream imageStream = Main.class.getResourceAsStream("lena.png");
        Main main = new Main();
        main.generateHash(imageStream);
    }
}
