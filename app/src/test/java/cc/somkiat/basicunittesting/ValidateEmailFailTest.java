package cc.somkiat.basicunittesting;

import org.junit.Test;
import static junit.framework.TestCase.assertFalse;

public class ValidateEmailFailTest {
    @Test

    public void ไม่ระบุอีเมล์ผลลัพธ์ต้องเป็นเท็จ() {
        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void อีเมล์ไม่มีชื่อผู้ใช้ผลลัพธ์ต้องเป็นเท็จ() {

        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("@hotmail.com");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void อีเมล์มีชื่อผู้ใช้ที่ไม่ถูกต้องผลลัพธ์ต้องเป็นเท็จ() {

        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("nt + pm96@hotmail.com");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void ไม่มีเครื่องหมายAtในอีเมล์ผลลัพธ์ต้องเป็นเท็จ() {

        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("ntpm96hotmail.com");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void โดเมนของอีเมลล์ผิดรูปแบบผลลัพธ์ต้องเป็นเท็จ() {

        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("ntpm96@hotmailcom");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void ไม่มีโดเมนของอีเมลล์ผลลัพธ์ต้องเป็นเท็จ() {

        EmailValidation validator = new EmailValidation();
        ValidateResult result = validator.validate("ntpm96@");
        assertFalse(result.getResultMessage(), result.isValid());

    }

}
