package com.Exception;

import com.CustomException.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalyzerTest {

    private String mood;

    @Test
    public void givenMood_WhenSad_ShouldReturnSad() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Sad", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMood_WhenAny_ShouldReturnHappy() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMood_WhenNull_ShouldReturnMessage() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }

    }

    @Test
    public void givenMood_WhenEmpty_ShouldReturnMessage() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }

    }
}
