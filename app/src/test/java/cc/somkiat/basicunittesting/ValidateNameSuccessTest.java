package cc.somkiat.basicunittesting;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class ValidateNameSuccessTest {

    @Test
    public void เมื่อใส่ชื่อผลลัพธ์ต้องเป็นจริง() {

        NameValidation validator = new NameValidation();
        ValidateResult result = validator.validate("Nathapath");
        assertTrue(result.getResultMessage(), result.isValid());

    }

    @Test
    public void ชื่อถูกรูปแบบผลลัพธ์ต้องเป็นจริง() {

        NameValidation validator = new NameValidation();
        ValidateResult result = validator.validate("Nathapath");
        assertTrue(result.getResultMessage(), result.isValid());

    }

    @Test
    public void ป้อนชื่อที่มีตัวอักษรระหว่างสองถึงสามสิบตัวผลลัพธ์ต้องเป็นจริง() {

        NameValidation validator = new NameValidation();
        ValidateResult result = validator.validate("Nathapath");
        assertTrue(result.getResultMessage(), result.isValid());

    }

}
