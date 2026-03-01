package nata;

// import java.util.Arrays;
// import java.util.Collections;

import java.util.Scanner;

public class nata {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        shuf quiz = new shuf();
        int score = 0;

        for (int interation = 0; interation < quiz.QuestionCount(); interation++) {
            System.out.println(quiz.questionGen());
            
            System.out.print("Your answer: ");
            char answer = userInput.nextLine().charAt(0);
            // System.out.println(quiz.answerChecker(answer));

            if (quiz.answerChecker(answer)) {
                ++score;

            } else {
                --score;
            }
        }
        System.out.println("Your final score is: " + score);
        





        /*old scripts reference logic */
        /*String[] letterOptions = new String[4];
        char letter = 'A';

        // String[] 
        
        
        
        int scoreCounter = 0;

        //Shuffle questions
        Integer[] questionIndices = new Integer[Questions.length];
        for (int i = 0; i < questionIndices.length; i++) {
            questionIndices[i] = i;
        }
        Collections.shuffle(Arrays.asList(questionIndices));

        //Question loop
        for (int Questionnaire = 0; Questionnaire < Questions.length; Questionnaire++) {
            int questIndex = questionIndices[Questionnaire];
            System.out.println("Q" + (Questionnaire + 1) + ": " + Questions[questIndex]);
            
           //Shuffle options
            String[] options = queStrings[questIndex].clone();
            Integer[] optionIndices = {0, 1, 2, 3};
            Collections.shuffle(Arrays.asList(optionIndices));
            
            //Find correct answer position after shuffle
            int correctAnswerPosition = -1;
            for (int i = 0; i < optionIndices.length; i++) {
                if (optionIndices[i] == 0) {
                    correctAnswerPosition = i;
                    break;
                }
            }
            
            //Options display loop
            for (int choice = 0; choice < optionIndices.length; choice++) {
                letterOptions[choice] = String.valueOf(letter);
                System.out.println("   " + letterOptions[choice] + ". " + options[optionIndices[choice]]);
                letter++;
            }

            System.out.print("Your answer: ");
            String userAnswer = userInput.nextLine().toUpperCase();

            if (userAnswer.isEmpty() || !Arrays.asList(letterOptions).contains(userAnswer)) {
                System.out.println("Invalid optionl.");
                break;
            } else if (userAnswer.equals(letterOptions[correctAnswerPosition])) {
                scoreCounter++;
            } else {
                scoreCounter--;
            }
            letter = 'A'; //reset 
            System.out.println();
        }

        if (scoreCounter > 0) {
            System.out.println("Congratulations, You scored " + scoreCounter + " out of " + Questions.length);
        } else {
            System.out.println("You scored " + scoreCounter + " out of " + Questions.length);   
        }*/
    }
}