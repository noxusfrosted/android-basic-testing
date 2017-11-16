package cc.somkiat.basicunittesting;

import org.junit.Test;
import static org.junit.Assert.assertFalse;


public class ValidateNameFailTest {

    @Test
    public void ไม่ระบุชื่อผลลัพธ์ต้องเป็นท็จ() {

        NameValidation validator = new NameValidation();
        ValidateResult result = validator.validate("");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void ชื่อมีรูปแบบที่ไม่ถูกต้องผลลัพธ์ต้องเป็นเท็จ() {

        NameValidation validator = new NameValidation();
        ValidateResult result = validator.validate("123Nathapath Mangkorn456");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void ชื่อมีสองตัวอักษรผลลัพธ์ต้องเป็นเท็จ() {

        NameValidation validator = new NameValidation();
        ValidateResult result = validator.validate("Ab");
        assertFalse(result.getResultMessage(), result.isValid());

    }

    @Test
    public void ชื่อมีตัวอักษรสามสิบตัวผลลัพธ์ต้องเป็นเท็จ() {

        NameValidation validator = new NameValidation();
        ValidateResult result = validator.validate("Nathapathmangkornhahahahahahaa");
        assertFalse(result.getResultMessage(), result.isValid());

    }

}
