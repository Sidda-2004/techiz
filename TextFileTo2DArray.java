package quiz;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class TextFileTo2DArray {
	public String[][] quizArray;
	public TextFileTo2DArray(String filePath){
		//String filePath = "C:\\Users\\HP\\eclipse-workspace\\quizApplication\\src\\quiz\\application\\quiz.txt"; // Replace with your file path
        List<String[]> quizData = new ArrayList<>();
        List<String> currentQuestion = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    currentQuestion.add(line);
                } else if (!currentQuestion.isEmpty()) {
                    quizData.add(currentQuestion.toArray(new String[0]));
                    currentQuestion.clear();
                }
            }

            if (!currentQuestion.isEmpty()) {
                quizData.add(currentQuestion.toArray(new String[0]));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Convert the list of arrays to a 2D array
        quizArray = quizData.toArray(new String[0][]);
	}
	String [][] questions() {
		return quizArray;
	}

    public static void main(String[] args) {
        
    	String filePath = "C:\\Users\\HP\\eclipse-workspace\\quizApplication\\src\\quiz\\application\\quiz.txt"; // Replace with your file path
        List<String[]> quizData = new ArrayList<>();
        List<String> currentQuestion = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    currentQuestion.add(line);
                } else if (!currentQuestion.isEmpty()) {
                    quizData.add(currentQuestion.toArray(new String[0]));
                    currentQuestion.clear();
                }
            }

            if (!currentQuestion.isEmpty()) {
                quizData.add(currentQuestion.toArray(new String[0]));
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Convert the list of arrays to a 2D array
        String[][] quizArray = quizData.toArray(new String[0][]);
        //System.out.println(quizArray);
        for (String[] questionData : quizArray) {
            // The first element is the question
            System.out.println(questionData[0]);

            // Iterate through the options (skip the first element)
            for (int i = 1; i < questionData.length; i++) {
                System.out.println(questionData[i]);
            }
        }

        // Now, quizArray contains the questions and options in a 2D string array
        // You can access and manipulate the data as needed
    }
}