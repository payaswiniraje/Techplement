package com.quizgenerator;

import java.util.Scanner;

public class QuizGeneratorApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Quiz quiz = new Quiz();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create a new quiz");
            System.out.println("2. Take the quiz");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    takeQuiz();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createQuiz() {
        System.out.println("Enter the number of questions:");
        int numQuestions = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numQuestions; i++) {
            System.out.println("Enter the question:");
            String questionText = scanner.nextLine();
            Question question = new Question(questionText);

            System.out.println("Enter the number of options:");
            int numOptions = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int j = 0; j < numOptions; j++) {
                System.out.println("Enter option " + (j + 1) + ":");
                String optionText = scanner.nextLine();
                System.out.println("Is this option correct? (yes/no):");
                boolean isCorrect = scanner.nextLine().equalsIgnoreCase("yes");
                question.addOption(optionText, isCorrect);
            }

            quiz.addQuestion(question);
        }
    }

    private static void takeQuiz() {
        if (quiz.getQuestions().isEmpty()) {
            System.out.println("No quiz available. Please create a quiz first.");
            return;
        }

        int score = 0;
        for (Question question : quiz.getQuestions()) {
            System.out.println("Question: " + question.getQuestionText());
            for (String option : question.getOptions().keySet()) {
                System.out.println(option);
            }

            System.out.println("Enter your answer:");
            String answer = scanner.nextLine();

            if (question.isCorrect(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + quiz.getQuestions().size());
    }
}
