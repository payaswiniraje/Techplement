
package com.quizgenerator;

import java.util.HashMap;
import java.util.Map;

public class Question {
    private String questionText;
    private Map<String, Boolean> options; // Maps option text to whether it is the correct answer

    public Question(String questionText) {
        this.questionText = questionText;
        this.options = new HashMap<>();
    }

    public void addOption(String option, boolean isCorrect) {
        options.put(option, isCorrect);
    }

    public String getQuestionText() {
        return questionText;
    }

    public Map<String, Boolean> getOptions() {
        return options;
    }

    public boolean isCorrect(String option) {
        return options.getOrDefault(option, false);
    }
}
