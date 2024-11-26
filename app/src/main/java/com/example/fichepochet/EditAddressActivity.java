package com.example.fichepochet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditAddressActivity extends AppCompatActivity {
    private EditText addressNumberEditText, streetEditText, postalCodeEditText, cityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);

        addressNumberEditText = findViewById(R.id.addressNumberEditText);
        streetEditText = findViewById(R.id.streetEditText);
        postalCodeEditText = findViewById(R.id.postalCodeEditText);
        cityEditText = findViewById(R.id.cityEditText);

        // Get initial data from MainActivity
        Intent intent = getIntent();
        addressNumberEditText.setText(intent.getStringExtra("addressNumber"));
        streetEditText.setText(intent.getStringExtra("street"));
        postalCodeEditText.setText(intent.getStringExtra("postalCode"));
        cityEditText.setText(intent.getStringExtra("city"));

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
        resultIntent.putExtra("addressNumber", addressNumberEditText.getText().toString());
        resultIntent.putExtra("street", streetEditText.getText().toString());
        resultIntent.putExtra("postalCode", postalCodeEditText.getText().toString());
        resultIntent.putExtra("city", cityEditText.getText().toString());
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
