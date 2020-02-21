package com.moodAnalyzer;

import com.CustomException.MoodAnalysisException;
import java.lang.reflect.Constructor;

public class MoodAnalyseFactory {

    public static MoodAnalyzer createMoodAnalyser() {
        try {
            Constructor<?> constructor = Class.forName("com.moodAnalyzer.MoodAnalyzer").getConstructor();
            Object myObj = constructor.newInstance();
            return (MoodAnalyzer)myObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String className,Class constructor) {
        Class<?> moodAnalyser = null;
        try {
            moodAnalyser = Class.forName(className);
            return moodAnalyser.getConstructor(constructor);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static MoodAnalyzer createMoodAnalyser(String message) {
        try {
            Constructor<?> constructor = Class.forName("com.moodAnalyzer.MoodAnalyzer").getConstructor(String.class);
            Object myObj = constructor.newInstance(message);
            return (MoodAnalyzer) myObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
