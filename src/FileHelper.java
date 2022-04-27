import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHelper {

    public static Scanner readFile(String path) {
        return readFile(path, true);
    }

    public static Scanner readFile(String path, boolean withErrorMessage) {
        File file = new File(path);

        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            if (withErrorMessage) {
                System.out.println("file not found");
            }
            return null;
        }

        return scanner;
    }
}