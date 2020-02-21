package com.moodAnalyzer;

import com.CustomException.MoodAnalysisException;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer() {
        message="Default Message";
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }


    public String analyzeMood() {
        try {
            if (message.isEmpty())
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, "Please Enter Proper Message");
            if (message.contains("Sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL, "Please Enter Proper Message");
        }
    }

    public boolean equals(Object another){
        if(this.message.equals(((MoodAnalyzer)another).message))
            return true;
        return false;
    }
}
