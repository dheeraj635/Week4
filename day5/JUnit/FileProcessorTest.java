
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;

class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim(); 
    }

    public boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }
}

public class FileProcessorTest {

    private FileProcessor fileProcessor;
    private String filename = "testFile.txt";

    @BeforeEach
    public void setup() {
        fileProcessor = new FileProcessor();
    }

    @Test
    public void testWriteToFile() throws IOException {
        String content = "Hello, world!";
        fileProcessor.writeToFile(filename, content);

        // Check if the file exists after writing
        assertTrue(fileProcessor.fileExists(filename), "File should exist after writing");

        // Read back the content to verify it was written correctly
        String fileContent = fileProcessor.readFromFile(filename);
        assertEquals(content, fileContent, "Content written to file should match the expected content");
    }

    @Test
    public void testReadFromFile() throws IOException {
        String content = "Sample text for reading.";
        fileProcessor.writeToFile(filename, content);

        
        String fileContent = fileProcessor.readFromFile(filename);
        assertEquals(content, fileContent, "Content read from file should match the expected content");
    }

    @Test
    public void testFileDoesNotExist() {
        String nonExistentFile = "nonExistentFile.txt";

        
        assertFalse(fileProcessor.fileExists(nonExistentFile), "File should not exist before writing");

        
        assertThrows(IOException.class, () -> fileProcessor.readFromFile(nonExistentFile), "Reading from a non-existent file should throw an exception");
    }

    @Test
    public void testIOExceptionWhenFileDoesNotExist() {
        String nonExistentFile = "nonExistentFile.txt";

        
        assertThrows(IOException.class, () -> fileProcessor.readFromFile(nonExistentFile), "Reading from a non-existent file should throw an IOException");
    }
}
