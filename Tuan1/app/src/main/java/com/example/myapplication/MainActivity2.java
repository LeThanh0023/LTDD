package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    TextView tv_pt, tv_kq;
    Button bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Ánh xạ id
        tv_pt = findViewById(R.id.tv_pt);
        tv_kq = findViewById(R.id.tv_kq);
        bt_back = findViewById(R.id.bt_back);

        // Nhận Intent và Bundle
        Intent myintent = getIntent();
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        Double a = mybundle.getDouble("a");
        Double b = mybundle.getDouble("b");
        Double c = mybundle.getDouble("c");
        DecimalFormat dcf = new DecimalFormat("0.00");
        tv_pt.setText(a + "x² + " + b +"x + " + c);
        // Giải phương trình bậc 2
        if (a == 0) {
            // Nếu a = 0, chuyển về phương trình bậc nhất
            if (b != 0) {
                double x = -c / b;
                tv_kq.setText("Phương trình trở thành bậc nhất: x = " + dcf.format(x));
            } else {
                if (c == 0) {
                    tv_kq.setText("Vô số nghiệm");
                } else {
                    tv_kq.setText("Phương trình vô nghiệm");
                }
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                tv_kq.setText("Phương trình vô nghiệm");
            } else if (delta == 0) {
                double x = -b / (2.0 * a);
                tv_kq.setText("x1 = x2 = " + dcf.format(x));
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
                tv_kq.setText("x1 = " + dcf.format(x1) + "\nx2 = " + dcf.format(x2));
            }
        }

        // Xử lý sự kiện nút "Back" để trở về Activity trước đó
        bt_back.setOnClickListener(v -> finish());
    }
}
