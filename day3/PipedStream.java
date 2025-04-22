import java.io.*;

package day21;

public class PipedStream {
    public static void main(String[] args) {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream;

        try {
            pipedOutputStream = new PipedOutputStream(pipedInputStream);

            Thread writerThread = new Thread(() -> {
                try {
                    for (int i = 1; i <= 5; i++) {
                        pipedOutputStream.write(("Message " + i + "\n").getBytes());
                        Thread.sleep(500);
                    }
                    pipedOutputStream.close();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    while ((data = pipedInputStream.read()) != -1) {
                        System.out.print((char) data);
                    }
                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
