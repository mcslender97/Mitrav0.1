package com.vodnal.mitra;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(RegisterValidator.isValidEmail("chanti@email.com"));
    }
    @Test
    public void passwordValidator_CorrectPasswordSample_ReturnsTrue() {
        assertTrue(RegisterValidator.isEmptyOrNot(""));
    }
    @Test
    public void phoneValidator_CorrectMobileNumSample_ReturnsTrue() {
        assertTrue(RegisterValidator.isValidMobileNum("+919167005085"));
    }
    @Test
    public void addressValidator_CorrectAddressSample_ReturnsTrue() {
        assertTrue(RegisterValidator.isEmptyOrNot(""));
    }
    @Test
    public void ageValidator_CorrectAgeSample_ReturnsTrue() {
        assertTrue(RegisterValidator.ageValidation(20));
    }

}