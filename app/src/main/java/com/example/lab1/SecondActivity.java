package com.example.lab1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    private TextView labelMessage;
    private Button buttonBack;
    private EditText etSayMyName;
    private Button btnNext;

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
        etSayMyName = findViewById(R.id.et_sayMyName);
        btnNext = findViewById(R.id.btn_Next);

        // Пришедшие данные из Intent
        Intent intent = getIntent();
        String greeting = intent.getStringExtra("greeting");
        labelMessage.setText(greeting);

        // Обработка ввода текста
        etSayMyName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Показываем кнопку, если поле не пустое
                btnNext.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Обработка нажатия кнопки "->"
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etSayMyName.getText().toString().trim();
                Intent intent;

                if (name.equalsIgnoreCase("Heisenberg") || name.equalsIgnoreCase(("Хайзенберг"))) {
                    intent = new Intent(SecondActivity.this, FourthActivity.class);
                } else {
                    intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("name", name);
                }
                startActivity(intent);
            }
        });

        // Обработка нажатия на кнопку "Назад"
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
