package com.example.fichepochet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int EDIT_IDENTITY_REQUEST_CODE = 1;
    private static final int EDIT_ADDRESS_REQUEST_CODE = 2;

    private TextView nameTextView, firstNameTextView, phoneTextView;
    private TextView addressNumberTextView, streetTextView, postalCodeTextView, cityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        nameTextView = findViewById(R.id.nameTextView);
        firstNameTextView = findViewById(R.id.firstNameTextView);
        phoneTextView = findViewById(R.id.phoneTextView);
        addressNumberTextView = findViewById(R.id.addressNumberTextView);
        streetTextView = findViewById(R.id.streetTextView);
        postalCodeTextView = findViewById(R.id.postalCodeTextView);
        cityTextView = findViewById(R.id.cityTextView);

        Button editIdentityButton = findViewById(R.id.editIdentityButton);
        Button editAddressButton = findViewById(R.id.editAddressButton);

        editIdentityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startEditActivity(EditIdentityActivity.class, EDIT_IDENTITY_REQUEST_CODE);
            }
        });

        editAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startEditActivity(EditAddressActivity.class, EDIT_ADDRESS_REQUEST_CODE);
            }
        });
    }

    private void startEditActivity(Class<?> activityClass, int requestCode) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        // Pass current data to edit activity
        intent.putExtra("name", nameTextView.getText().toString());
        intent.putExtra("firstName", firstNameTextView.getText().toString());
        intent.putExtra("phone", phoneTextView.getText().toString());
        intent.putExtra("addressNumber", addressNumberTextView.getText().toString());
        intent.putExtra("street", streetTextView.getText().toString());
        intent.putExtra("postalCode", postalCodeTextView.getText().toString());
        intent.putExtra("city", cityTextView.getText().toString());
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == EDIT_IDENTITY_REQUEST_CODE) {
                // Update identity fields
                nameTextView.setText(data.getStringExtra("name"));
                firstNameTextView.setText(data.getStringExtra("firstName"));
                phoneTextView.setText(data.getStringExtra("phone"));
            } else if (requestCode == EDIT_ADDRESS_REQUEST_CODE) {
                // Update address fields
                addressNumberTextView.setText(data.getStringExtra("addressNumber"));
                streetTextView.setText(data.getStringExtra("street"));
                postalCodeTextView.setText(data.getStringExtra("postalCode"));
                cityTextView.setText(data.getStringExtra("city"));
            }
        }
    }
}