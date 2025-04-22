import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

package day21;

public class ReadLargeFileLinebyLine {
        public static void main(String[] args) {
            String filePath = "path/to/largefile.txt";
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.toLowerCase().contains("error")) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
