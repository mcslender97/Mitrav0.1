package com.vodnal.mitra;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    RegisterUser testUser = new RegisterUser(1,"Minh Cuong Do","chanti@email.com","demopassword","+919167005085","10 Downs Str","Prefer not to say");
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
    @Test
    public void emailValidator_IncorrectEmailSimple_ReturnsFalse() {
        assertFalse(RegisterValidator.isValidEmail("hanzo@email"));
    }

    @Test
    public void phoneValidator_IncorrectMobileNumSample_ReturnsFalse() {
        assertFalse(RegisterValidator.isValidMobileNum("+2"));
    }

    @Test
    public void ageValidator_IncorrectAgeSample_ReturnsFalse() {
        assertFalse(RegisterValidator.ageValidation(10));
    }
    @Test
    public void editUserName_Test(){
        testUser.setEmail("hanzomain@gmail.com");
        assertEquals("hanzomain@gmail.com",testUser.getEmail());
    }

}