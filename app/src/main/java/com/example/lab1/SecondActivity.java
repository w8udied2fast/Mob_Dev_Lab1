package com.example.lab1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    private TextView labelMessage;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonBack = findViewById(R.id.btn_Back);
        labelMessage = findViewById(R.id.tv_labelMessage);

        // Пришедшие данные из Intent
        Intent intent = getIntent();
        String greeting = intent.getStringExtra("greeting");
        labelMessage.setText(greeting);

        // Обработка нажатия на кнопку "Назад"
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
