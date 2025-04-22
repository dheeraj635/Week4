import java.io.*;

public class ByteArrayStream {
        public static void main(String[] args) {
            String inputImagePath = "input.jpg";
            String outputImagePath = "output.jpg";

            try (FileInputStream fis = new FileInputStream(inputImagePath);
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 FileOutputStream fos = new FileOutputStream(outputImagePath)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead); 
                }

                byte[] imageBytes = baos.toByteArray();
                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
