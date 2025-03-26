package com.example.studentteacherui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 99;
    private EditText editTextStudent, editTextCorrected;
    private Button buttonSubmit, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStudent = findViewById(R.id.editTextStudent);
        editTextCorrected = findViewById(R.id.editTextCorrected);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonClear = findViewById(R.id.buttonClear);

        buttonSubmit.setOnClickListener(v -> {
            String studentText = editTextStudent.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("student_text", studentText);
            startActivityForResult(intent, REQUEST_CODE);
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextStudent.setText("");
                editTextCorrected.setText("");

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            String correctedText = data.getStringExtra("corrected_text");
            editTextCorrected.setText(correctedText);
        }
    }


}
