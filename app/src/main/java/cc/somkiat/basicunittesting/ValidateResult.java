package cc.somkiat.basicunittesting;

class ValidateResult {

    private String resultMessage;
    private boolean isValid;

    public ValidateResult(boolean isValid, String resultMessage) {

        this.isValid = isValid;
        this.resultMessage = resultMessage;

    }

    public boolean isValid() {

        return isValid;

    }

    public String getResultMessage() {

        return resultMessage;

    }
}
