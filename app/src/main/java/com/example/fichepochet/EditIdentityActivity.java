package com.example.fichepochet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditIdentityActivity extends AppCompatActivity {

    private EditText nameEditText, firstNameEditText, phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_identity);

        nameEditText = findViewById(R.id.nameEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);

        // Get initial data from MainActivity
        Intent intent = getIntent();
        nameEditText.setText(intent.getStringExtra("name"));
        firstNameEditText.setText(intent.getStringExtra("firstName"));
        phoneEditText.setText(intent.getStringExtra("phone"));

        Button validateButton = findViewById(R.id.validateButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close activity without sending result
            }
        });
    }

    private void sendResult() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("name", nameEditText.getText().toString());
        resultIntent.putExtra("firstName", firstNameEditText.getText().toString());
        resultIntent.putExtra("phone", phoneEditText.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}