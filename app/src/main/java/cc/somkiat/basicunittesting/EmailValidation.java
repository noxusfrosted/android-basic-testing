package cc.somkiat.basicunittesting;

import java.util.regex.Pattern;

class EmailValidation {

    public ValidateResult validate(String emailValue) {

        try {

            isEmailNotEmpty(emailValue);
            isEmailPatternCorrect(emailValue);

        } catch (ValidateException e) {

            return new ValidateResult(false, e.getMessage());
        }

        return new ValidateResult(true, "Email is valid");
    }

    private void isEmailNotEmpty(String emailValue) throws ValidateException {

        if (emailValue.isEmpty()) {

            throw new ValidateException("Email is empty");
        }
    }

    private void isEmailPatternCorrect(String emailValue) throws ValidateException {

        String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";

        if (!Pattern.matches(emailPattern, emailValue)) {

            throw new ValidateException("Email Pattern is incorrect");

        }
    }
}
