package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;

    UserStorage userStorage = UserStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        firstNameInput = findViewById(R.id.editFirstName);
        lastNameInput = findViewById(R.id.editLastName);
        emailInput = findViewById(R.id.editEmail);
    }

    public void addUser(View view)  {
        RadioGroup rgStudyField = findViewById(R.id.rgStudyField);

        try {
            String firstName = firstNameInput.getText().toString();
            String lastName = lastNameInput.getText().toString();
            String email = emailInput.getText().toString();

            switch (rgStudyField.getCheckedRadioButtonId()) {
                case R.id.rbEnTe:
                    userStorage.addUser(new User(firstName, lastName, email, "Energiatekniikka"));
                    System.out.println("Ente-casessa ollaan!");
                    break;
                case R.id.rbLaTe:
                    userStorage.addUser(new User(firstName, lastName, email, "Laskennallinen tekniikka"));
                    System.out.println("Late-casessa ollaan!");
                    break;
                case R.id.rbSäTe:
                    userStorage.addUser(new User(firstName, lastName, email, "Sähkötekniikka"));
                    System.out.println("Säte-casessa ollaan!");
                    break;
                case R.id.rbTiTe:
                    userStorage.addUser(new User(firstName, lastName, email, "Tietotekniikka"));
                    System.out.println("Tite-casessa ollaan!");
                    break;
                default:
                    Toast.makeText(this, "Täytä kaikki kentät oikein.", Toast.LENGTH_LONG).show();
                    System.out.println("Täytä kaikki kentät oikein.");
            }
        } catch (Exception e) {
            Toast.makeText(this, "Täytä kaikki kentät oikein.", Toast.LENGTH_LONG).show();
            System.out.println("Täytä kaikki kentät oikein.");
        }

    }
}