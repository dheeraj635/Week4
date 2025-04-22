import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoClosingResource {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
