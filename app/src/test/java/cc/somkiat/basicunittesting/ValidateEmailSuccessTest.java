package cc.somkiat.basicunittesting;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class ValidateEmailSuccessTest {

    @Test
    public void เมื่อใส่อีเมล์ผลลัพธ์ต้องเป็นจริง() throws ValidateException {

        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("ntpm96@hotmail.com");
        assertTrue(result.getResultMessage(), result.isValid());

    }

    @Test
    public void อีเมล์ถูกรูปแบบผลลัพธ์ต้องเป็นจริง() {

        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("ntpm96@hotmail.com");
        assertTrue(result.getResultMessage(), result.isValid());

    }

}
