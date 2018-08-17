import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.img_hash.Img_hash;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public String generateHash(String imagePath) {

        Mat sourceCollage = Imgcodecs.imread(imagePath, Imgcodecs.CV_LOAD_IMAGE_COLOR);

        Mat destinationCollage = new Mat(sourceCollage.rows(), sourceCollage.cols(), sourceCollage.type());

        Img_hash.pHash(sourceCollage, destinationCollage);

        System.out.println("OpenCV Mat data:\n" + destinationCollage.dump());

        String[] elements = destinationCollage.dump()
                .replaceAll("\\[", "")
                .replaceAll("\\]","")
                .replaceAll(" ","")
                .split(",");

        String hash = String.join("-", elements);
        System.out.println(hash);

        return hash;
    }

    public static void main(String[] args) {
        String imagePath = Main.class.getResource("lena.png").getPath();
        System.out.println(imagePath);
        Main main = new Main();
        main.generateHash(imagePath);
    }
}
