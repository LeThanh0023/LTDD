package com.example.studentteacherui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText editTextTeacher;
    private Button buttonDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextTeacher = findViewById(R.id.editTextTeacher);
        buttonDone = findViewById(R.id.buttonDone);

        Intent intent = getIntent();
        String studentText = intent.getStringExtra("student_text");
        editTextTeacher.setText(studentText);

        buttonDone.setOnClickListener(v -> {
            String correctedText = editTextTeacher.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("corrected_text", correctedText);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
    }
}
