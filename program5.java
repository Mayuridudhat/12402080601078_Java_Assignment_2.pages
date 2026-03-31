import java.io.*;
import java.util.*;

public class Program5 {
    public static void main(String[] args) {
        String filename = "sample_text.txt";

        // Step 1: Create a dummy file to read from
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("hello world hello java java programming is fun");
            System.out.println("Sample file created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }

        // Step 2: Read the file and count word occurrences
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase();
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println("\n=== Word Occurrences ===");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}