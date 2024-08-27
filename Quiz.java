package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<QuizQuestion> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new QuizQuestion("What is the capital of France?", 
                new String[]{"1. Berlin", "2. Paris", "3. Madrid", "4. Rome"}, 2));
        questions.add(new QuizQuestion("Which language is used to write Android apps?",
                new String[]{"1. Swift", "2. Python", "3. Java", "4. Kotlin"}, 3));
        questions.add(new QuizQuestion("What is the square root of 64?", 
                new String[]{"1. 6", "2. 7", "3. 8", "4. 9"}, 3));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        QuizTimer quizTimer = new QuizTimer();

        for (QuizQuestion question : questions) {
            System.out.println("\n" + question.getQuestion());
            String[] options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }

            quizTimer.startTimer(10); // 10-second timer for each question
            int answer = -1;

            while (!quizTimer.isTimeUp()) {
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                    quizTimer.stopTimer();
                    break;
                }
            }

            if (quizTimer.isTimeUp()) {
                System.out.println("Time's up! Moving to the next question.");
            } else if (question.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }

            quizTimer.stopTimer();
        }
        scanner.close();
    }

    public void displayResults() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());
    }
}
