package cc.somkiat.basicunittesting;

import java.util.regex.Pattern;


class NameValidation {
    public ValidateResult validate(String nameValue) {

        try {
            isNameNotEmpty(nameValue);
            isNamePatternCorrect(nameValue);
            isNameLengthLessThanThirty(nameValue);
            isNameLengthMoreThanTwo(nameValue);
        } catch (ValidateException e) {
            return new ValidateResult(false, e.getMessage());
        }

        return new ValidateResult(true, "Name is valid");
    }

    private void isNameNotEmpty(String nameValue) throws ValidateException {

        if (nameValue.isEmpty()) {
            throw new ValidateException("Name is empty");
        }

    }

    private void isNamePatternCorrect(String nameValue) throws ValidateException {
        String namePattern = "[a-zA-Z]+ ?[a-zA-Z]+";

        if (!Pattern.matches(namePattern, nameValue)) {
            throw new ValidateException("Name Pattern is incorrect");
        }
    }

    private void isNameLengthMoreThanTwo(String nameValue) throws ValidateException {

        if (nameValue.length() <= 2) {
            throw new ValidateException("Name is too short");
        }

    }

    private void isNameLengthLessThanThirty(String nameValue) throws ValidateException {

        if (nameValue.length() >= 30) {
            throw new ValidateException("Name is too long");
        }

    }
}
