package com.example.ariketa_2;

import android.media.metrics.EditingSession;
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

import java.text.DecimalFormat;

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
        findViews();
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
                double bmiResult= calculateBmi();

                String ageText= ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);

                if(age>=18){
                    displayResult(bmiResult);
                }else{
                    displayGuidance(bmiResult);
                }


            }
        });
    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult =myDecimalFormatter.format(bmi);
        String fullResultString;

        if(maleButton.isChecked()){
            fullResultString = bmiTextResult + " If you are under 18 consult with your doctor";
        } else if(femaleButton.isChecked()){
            fullResultString=bmiTextResult+" If you are under 18 consult with your doctor";
        }else{
            fullResultString= bmiTextResult +"If you are under 18 consult with your doctor";
        }
        resulText.setText(fullResultString);
    }

    private double calculateBmi(){
        String feetText= feetEditText.getText().toString();
        String inchesText= inchesEditText.getText().toString();
        String weightText= weightEditText.getText().toString();

        int feet=Integer.parseInt(feetText);
        int inches=Integer.parseInt(inchesText);
        int weight=Integer.parseInt(weightText);

        int totalInches=(feet*12)+inches;

        double heightInMeter=totalInches*0.0254;

        return weight/(heightInMeter* heightInMeter);
    }
    private void  displayResult(double bmi){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult =myDecimalFormatter.format(bmi);
        String fullResultString;
        if(bmi <18.5){
            fullResultString=bmiTextResult+" You are underweight";
        } else if(bmi>25){
            fullResultString=bmiTextResult+ " You are overweight";
        } else {
            fullResultString=bmiTextResult+" You are healthy";
        }
        resulText.setText(fullResultString);
    }


}