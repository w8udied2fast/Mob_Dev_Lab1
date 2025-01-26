package com.example.lab1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;
    private Button buttonLogin;

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

        inputEmail = findViewById(R.id.et_inputEmail);
        inputPassword = findViewById(R.id.et_inputPassword);
        buttonLogin = findViewById(R.id.btn_Login);

        // обработка нажатия на кнопку "Войти"
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                if (email.equals("admin@admin.ru") && password.equals("123"))
                {
                    intent.putExtra("greeting", getString(R.string.greeting_login));
                }
                else
                {
                    intent.putExtra("greeting", getString(R.string.error_message));
                }
                startActivity(intent);
            }
        });
    }
}