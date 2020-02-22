package com.CustomException;

public class MoodAnalysisException extends RuntimeException {

    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD, NO_SUCH_FIELD, INVOCATION_ISSUE;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
