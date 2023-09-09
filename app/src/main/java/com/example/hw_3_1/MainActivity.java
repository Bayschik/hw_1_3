package com.example.hw_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.et_email);
        EditText theme = findViewById(R.id.et_theme);
        EditText message = findViewById(R.id.et_message);

        Button send = findViewById(R.id.btn_send);

        send.setOnClickListener(view -> {
            String gmail = email.getText().toString();
            String themes = theme.getText().toString();
            String messages = message.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{gmail});
            intent.putExtra(Intent.EXTRA_SUBJECT, themes);
            intent.putExtra(Intent.EXTRA_TEXT, messages);

            startActivity(Intent.createChooser(intent, "Send"));
        });
    }
}