package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai báo biến
    EditText edt_a, edt_b, edt_c;
    Button bt_next,bt_cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Ánh xạ id
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        edt_c = findViewById(R.id.edt_c);
        bt_next = findViewById(R.id.bt_next);
        bt_cl = findViewById(R.id.bt_cl);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent
                Intent myintent = new Intent(MainActivity.this, MainActivity2.class);
                // Lấy dữ liệu
                Double a = Double.valueOf(edt_a.getText().toString());
                Double b = Double.valueOf(edt_b.getText().toString());
                Double c = Double.valueOf(edt_c.getText().toString());
                // Đóng gói dữ liệu vào Bundle
                Bundle mybundle = new Bundle();
                // Đưa dữ liệu vào Bundle
                mybundle.putDouble("a", a);
                mybundle.putDouble("b", b);
                mybundle.putDouble("c", c);
                // Đưa Bundle vào Intent
                myintent.putExtra("mypackage", mybundle);
                // Khởi động Intent
                startActivity(myintent);
            }
        });
        bt_cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_a.setText("");
                edt_b.setText("");
                edt_c.setText("");
            }
        });
    }
}