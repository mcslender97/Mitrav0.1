package com.vodnal.mitra;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Pattern;

public class RegisterValidator implements TextWatcher {
    /**
     * Email validation pattern.
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );
    public static final Pattern MOBILE_PATTERN = Pattern.compile(
            "^\\+(?:[0-9] ?){6,14}[0-9]$"
    );
    private boolean mIsValid = false;
    public boolean isValid() {
        return mIsValid;
    }
    /**
     * Validates if the given input is a valid email address.
     *
     * @param email        The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    public static boolean isValidMobileNum(CharSequence email) {
        return email != null && MOBILE_PATTERN.matcher(email).matches();
    }
    public static boolean isEmptyOrNot(String string) {
        if(string != null && string.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean ageValidation(int age) {
        if(age > 12 && age < 60){
            return true;
        }
        return false;
    }
    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidEmail(editableText);
    }
    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}
    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}
}
