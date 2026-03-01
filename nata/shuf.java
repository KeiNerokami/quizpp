package nata;

import com.google.gson.Gson;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;

public class shuf {

    /*JSON VARIABLES*/

    private String[] Questions;
    private String[][] queStrings;

    private int ansIndex;
    private String queShuffleMode;
    private String ansShuffleMode;

    /*ORIGINAL VARIABLES*/

    private Integer[] questionOrder;
    private int currentQuestionIndex = 0;
    private char lastCorrectLetter = 'A';
    private int lastQuestionIndex = -1;

    /*CONSTRUCTOR*/

    public shuf() {
        loadJson(); // load from JSON first

        // original constructor logic preserved
        questionOrder = new Integer[Questions.length];
        for (int i = 0; i < questionOrder.length; i++) {
            questionOrder[i] = i;
        }
        Collections.shuffle(Arrays.asList(questionOrder));
    }

    /*JSON LOADER*/

    private void loadJson() {
        try {
            Gson gson = new Gson();

            Questions = gson.fromJson(
                    new FileReader("assets/questions.json"),
                    String[].class
            );

            queStrings = gson.fromJson(
                    new FileReader("assets/answers.json"),
                    String[][].class
            );

            Config config = gson.fromJson(
                    new FileReader("assets/config.json"),
                    Config.class
            );

            ansIndex = config.ans_index;
            queShuffleMode = config.queShuf;
            ansShuffleMode = config.ansShuf;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*CONFIG CLASS*/

    class Config {
        int ans_index;
        String queShuf;
        String ansShuf;
    }

    /*YOUR ORIGINAL METHODS BELOW*/

    public String Shuffler(String arryString) {
        Integer[] indices = new Integer[Questions.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Collections.shuffle(Arrays.asList(indices));

        StringBuilder shuffled = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            shuffled.append(arryString.charAt(indices[i]));
        }
        return shuffled.toString();
    }

    public String answerGen(int questionIndex) {
        StringBuilder options = new StringBuilder();
        for (String option : queStrings[questionIndex]) {
            options.append(option).append("\n");
        }
        return options.toString();
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questionOrder.length;
    }

    public char getLastCorrectLetter() {
        return lastCorrectLetter;
    }

    public int getLastQuestionIndex() {
        return lastQuestionIndex;
    }

    public boolean answerChecker(char letter) {
        return Character.toUpperCase(letter) == lastCorrectLetter;
    }

    public int QuestionCount() {
        return Questions.length;
    }

    public String questionGen() {

        if (!hasNextQuestion()) {
            return "No more questions.";
        }

        int qIndex = questionOrder[currentQuestionIndex++];
        lastQuestionIndex = qIndex;

        Integer[] optionOrder = {0, 1, 2, 3};
        Collections.shuffle(Arrays.asList(optionOrder));

        StringBuilder strBui = new StringBuilder();
        strBui.append(Questions[qIndex]).append("\n");

        char letter = 'A';

        for (int i = 0; i < optionOrder.length; i++) {
            if (optionOrder[i] == ansIndex) {  // uses config now
                lastCorrectLetter = letter;
            }

            strBui.append(letter)
                    .append(". ")
                    .append(queStrings[qIndex][optionOrder[i]])
                    .append("\n");

            letter++;
        }

        return strBui.toString();
    }

    public int getQuestionCount() {
        return Questions.length;
    }

    public int getAnsCount() {
        int ansCount = queStrings[0].length;
        int totalAnsCount = ansCount * queStrings.length;
        return totalAnsCount;
    }

    public boolean checkFunctionAnsChker(char letter) {
        return answerChecker(letter);
    }

    public boolean checkFunctionHasNext() {
        return hasNextQuestion();
    }
}