package quiz;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataToArrayConverter {
    public static void main(String[] args) {
        // Read data from a file (you can modify this to read from other sources)
    	DataToArrayConverter dac = new DataToArrayConverter();
        String[] lines = dac.readDataFromFile("C:\\Users\\HP\\eclipse-workspace\\quizApplication\\src\\quiz\\application\\answers.txt.txt");

        // Convert data to an array
       // String[] dataArray = lines.toArray(new String[0]);

        // Display the data
        for (String item : lines) {
            System.out.println(item);
        }
    }

    // Read data from a file and return it as a list of strings
    public  String[] readDataFromFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] dataArray = lines.toArray(new String[0]);
        return dataArray;
    }
}