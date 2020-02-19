package com.CustomException;

public class MoodAnalysisException extends RuntimeException {

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
