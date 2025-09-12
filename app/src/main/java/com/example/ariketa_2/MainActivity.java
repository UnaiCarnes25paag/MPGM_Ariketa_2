package com.example.ariketa_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView resulText;

    private Button calculateButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtonClickListener();

    }
    private void findViews(){
        resulText= findViewById(R.id.text_view_result) ;

        maleButton = findViewById(R.id.radio_button_male);

        femaleButton = findViewById(R.id.radio_button_female);

        ageEditText = findViewById(R.id.edit_text_age);

        feetEditText = findViewById(R.id.edit_text_feet);

        inchesEditText = findViewById(R.id.edit_text_inches);

        weightEditText = findViewById(R.id.edit_text_weight);

        calculateButton=findViewById(R.id.button_calculate);
    }

    private void setUpButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();


            }
        });
    }
    private void calculateBmi(){
        String ageText= ageEditText.getText().toString();
        String feetText= feetEditText.getText().toString();
        String inchesText= inchesEditText.getText().toString();
        String weightText= weightEditText.getText().toString();

        int age=Integer.parseInt(ageText);
        int feet=Integer.parseInt(feetText);
        int inches=Integer.parseInt(inchesText);
        int weight=Integer.parseInt(weightText);

        int totalInches=(feet*12)+inches;

        double heightInMeter=totalInches*0.0254;

        double bmi=weight/(heightInMeter* heightInMeter);

        String bmiTextResult= String.valueOf(bmi);
        resulText.setText(bmiTextResult);
    }


}