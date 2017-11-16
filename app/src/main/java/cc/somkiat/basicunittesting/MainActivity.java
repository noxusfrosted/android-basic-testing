package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private NameValidation nameValidation;
    private EmailValidation emailValidation;
    private EditText nameEditText;
    private EditText emailEditText;
    private DatePicker birthDayDataPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.userNameInput);
        birthDayDataPicker = findViewById(R.id.dateOfBirthInput);
        emailEditText = findViewById(R.id.emailInput);

        nameValidation = new NameValidation();
        emailValidation = new EmailValidation();
    }

    public void onSaveClick(View view) {

        String nameValue = nameEditText.getText().toString();
        String emailValue = emailEditText.getText().toString();
        showResult(nameValidation.validate(nameValue), emailValidation.validate(emailValue));

    }

    public void onRevertClick(View view) {

        Time currentTime = new Time();
        currentTime.setToNow();
        nameEditText.setText("");
        birthDayDataPicker.updateDate(currentTime.year, currentTime.month, currentTime.monthDay);
        emailEditText.setText("");

    }


    private void showResult(ValidateResult nameResult, ValidateResult emailResult) {

        if (!nameResult.isValid()) {

            Toast.makeText(this, nameResult.getResultMessage(), Toast.LENGTH_SHORT).show();
        }

        if (!emailResult.isValid()) {
            Toast.makeText(this, emailResult.getResultMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
