package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView firstTextView;
    private TextView secondTextView;
    private TextView thirdTextView;

    private EditText firstEditText;
    private EditText secondEditText;

    private Button blueButton;
    private Button greenButton;

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_simple_view);

        firstTextView = findViewById(R.id.firstTextView);
        secondTextView = findViewById(R.id.secondTextView);
        thirdTextView = findViewById(R.id.thirdTextView);


        firstEditText = findViewById(R.id.firstEditText);
        secondEditText = findViewById(R.id.secondEditText);

        blueButton = findViewById(R.id.blueButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contentFromEditText = firstEditText.getText().toString();

                if (contentFromEditText != null && contentFromEditText.length() > 0) {
                    firstTextView.setText(contentFromEditText);
                } else {
                    firstTextView.setError(getString(R.string.error_missing_text));
                }
            }
        });

        greenButton = findViewById(R.id.greenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contentFromEditText = secondEditText.getText().toString();

                if (contentFromEditText != null && contentFromEditText.length() > 0) {
                    thirdTextView.setText(contentFromEditText);
                } else {
                    thirdTextView.setError(getString(R.string.error_missing_text));
                }
            }
        });

        checkBox = findViewById(R.id.checkboxNotify);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    secondTextView.setText(R.string.checkbox_checked);
                } else {
                    secondTextView.setText(R.string.checkbox_unchecked);
                }
            }
        });


    }


}