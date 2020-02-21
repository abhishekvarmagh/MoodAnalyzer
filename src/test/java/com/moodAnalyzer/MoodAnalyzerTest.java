package com.moodAnalyzer;

import com.CustomException.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    private String mood;

    //Given a Message to analyse and respond Sad Mood
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

    //Given a Message to analyse and respond Happy Mood
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

    //Handle Exception if User Provides Invalid Mood Like Null
    @Test
    public void givenMood_WhenNull_ShouldReturnMessage() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }

    }

    //Handle Exception if User Provides Invalid Mood Like Empty
    @Test
    public void givenMood_WhenEmpty_ShouldReturnMessage() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    //Use Reflection to Create MoodAnalyser with default Constructor
    @Test
    public void givenMoodAnalyzerDefault_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyser = MoodAnalyseFactory.createMoodAnalyser();
        Assert.assertEquals(new MoodAnalyzer(), moodAnalyser);
    }

    //Given Class Name When Improper Should Throw MoodAnalysisException
    @Test
    public void givenClassName_WhenImproper_ShouldReturnMoodAnalysisException() {
        try {
            MoodAnalyseFactory.getConstructor("com.moodAnalyzer.MooAnalyzer", int.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    //Given Class When Constructor Not Proper Should Throw MoodAnalysisException
    @Test
    public void givenClass_WhenConstructorNotProper_ShouldReturnMoodAnalysisException() {
        try {
            MoodAnalyseFactory.getConstructor("com.moodAnalyzer.MoodAnalyzer", int.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    //Use Reflection to Create MoodAnalyser with Parameter Constructor
    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyseFactory.createMoodAnalyser("I am in Happy Mood");
        Assert.assertEquals(new MoodAnalyzer("I am in Happy Mood"), moodAnalyzer);
    }
}
