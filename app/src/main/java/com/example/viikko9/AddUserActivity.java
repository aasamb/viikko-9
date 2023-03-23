package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;

    ArrayList<EditText> textFields;

    UserStorage userStorage = UserStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstNameInput = findViewById(R.id.editFirstName);
        lastNameInput = findViewById(R.id.editLastName);
        emailInput = findViewById(R.id.editEmail);

        textFields = new ArrayList<>(Arrays.asList(firstNameInput, lastNameInput, emailInput));
    }

    public void addUser(View view) {
        RadioGroup rgStudyField = findViewById(R.id.rgStudyField);
        RadioGroup rgImageSelect = findViewById(R.id.rgImageSelect);

        int image = 0;
        String degreeProgram = "";
        boolean allFieldsFilled;

        System.out.println("Metodissa ollaan!");

        //try {
        boolean emptyString = isEmptyStrings();
        allFieldsFilled = !emptyString;
        //System.out.println("'emptyString' ennen testiä: " + String.valueOf(emptyString));

        System.out.println("'emptyString' testin jälkeen: " + emptyString);
        System.out.println("'noEmptyFields' testin jälkeen: " + allFieldsFilled);

        //System.out.println("if-lausekkeessa ollaan arvolla: " + String.valueOf(emptyString));

        switch (rgStudyField.getCheckedRadioButtonId()) {
            case R.id.rbEnTe:
                degreeProgram = "Energiatekniikka";
                break;
            case R.id.rbLaTe:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSäTe:
                degreeProgram = "Sähkötekniikka";
                break;
            case R.id.rbTiTe:
                degreeProgram = "Tietotekniikka";
                break;
            default:
                Toast.makeText(this, "Valitse ala.", Toast.LENGTH_LONG).show();
                System.out.println("Valitse ala.");
                allFieldsFilled = false;
        }

        switch (rgImageSelect.getCheckedRadioButtonId()) {
            case R.id.rbKirby:
                image = R.drawable.kirby;
                break;
            case R.id.rbLink:
                image = R.drawable.link;
                break;
            case R.id.rbLuigi:
                image = R.drawable.luigi;
                break;
            case R.id.rbMario:
                image = R.drawable.mario;
                break;
            case R.id.rbNoImage:
                image = 0;
                break;
            default:
                Toast.makeText(this, "Valitse kuva.", Toast.LENGTH_LONG).show();
                System.out.println("Valitse kuva.");
                allFieldsFilled = false;
                break;
        }


        if (allFieldsFilled) {
            String firstName = firstNameInput.getText().toString();
            String lastName = lastNameInput.getText().toString();
            String email = emailInput.getText().toString();
            userStorage.addUser(new User(firstName, lastName, email, degreeProgram, image));
            //System.out.println("Käyttäjä tallennettu.");

        } else {
            if (emptyString) {
                Toast.makeText(this, "Täytä tekstikentät.", Toast.LENGTH_LONG).show();
                System.out.println("Täytä tekstikentät.");
            }
            Toast.makeText(this, "Käyttäjää ei tallennettu.", Toast.LENGTH_LONG).show();
            System.out.println("Käyttäjää ei tallennettu.");
        }

        //} catch (Exception e) {
        //Toast.makeText(this, "Täytä kaikki kentät oikein.", Toast.LENGTH_LONG).show();
        //System.out.println("Täytä kaikki kentät oikein. Tuntematon poikkeus: " + e.toString());
    //}

}

    public boolean isEmptyStrings() {
        boolean emptyString = false;
        for (EditText textField : textFields) {
            emptyString = textField.getText().toString().isEmpty();
            System.out.println("Yksittäinen 'emptyString': " + String.valueOf(emptyString));
            if (emptyString) {
                break;
            }
        }
        return emptyString;
    }

}