import java.io.*;

package day21;

public class FilterStream {
        public static void main(String[] args) {
            try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line.toLowerCase());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
