import java.io.*;

package day21;

public class EfficientFile {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFileBuffered = "destBuffered.txt";
        String destFileUnbuffered = "destUnbuffered.txt";

        try {
            long bufferedTime = copyWithBufferedStreams(sourceFile, destFileBuffered);
            long unbufferedTime = copyWithUnbufferedStreams(sourceFile, destFileUnbuffered);

            System.out.println("Buffered Streams Time: " + bufferedTime + " ns");
            System.out.println("Unbuffered Streams Time: " + unbufferedTime + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long copyWithBufferedStreams(String source, String dest) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[4096];
            long startTime = System.nanoTime();
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return System.nanoTime() - startTime;
        }
    }

    private static long copyWithUnbufferedStreams(String source, String dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[4096];
            long startTime = System.nanoTime();
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            return System.nanoTime() - startTime;
        }
    }
}
