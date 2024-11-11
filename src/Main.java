import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        }
        else {
            System.out.println("No file selected. Exiting program.");
        }
    }
    private static void processFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            String line = "";

            while ((line = reader.readLine()) != null) {
                lineCount++;

                String[] words = line.split("\\s+");
                wordCount += words.length;

                charCount += line.length();
            }

            System.out.println("File Summary:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}