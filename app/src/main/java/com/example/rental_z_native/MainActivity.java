package com.example.rental_z_native;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {
    String property, bedroom, rent, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText propertyName = findViewById(R.id.propertyName);
        EditText bedroomName = findViewById(R.id.bedroomName);
        EditText rentPrice = findViewById(R.id.rentPrice);
        EditText nameReporter = findViewById(R.id.nameReporter);
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            property = propertyName.getText().toString();
            bedroom = bedroomName.getText().toString();
            rent = rentPrice.getText().toString();
            name = nameReporter.getText().toString();
            if (!validationProperty() || !validationBedroom() || !validationRentPrice() || !validationNameReporter()) {
                return;
            }
            openDialog();
        });
    }

    public void openDialog() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Dialog dialogFragment = new Dialog();
        Bundle bundle = new Bundle();
        bundle.putString("property", property);
        bundle.putString("bedroom", bedroom);
        bundle.putString("rentPrice", rent);
        bundle.putString("nameReporter", name);
        bundle.putString("date", dtf.format(now));
        dialogFragment.setArguments(bundle);
        dialogFragment.show(getSupportFragmentManager(), "Parameter");

    }

    ;

    public boolean validationProperty() {
        EditText propertyName = findViewById(R.id.propertyName);
        String value = propertyName.getText().toString();
        if (value.isEmpty()) {
            propertyName.setError("Not empty");
            return false;
        } else {
            propertyName.setError(null);
            return true;
        }
    }

    private boolean validationBedroom() {
        EditText bedroomName = findViewById(R.id.bedroomName);
        String value = bedroomName.getText().toString();
        if (value.isEmpty()) {
            bedroomName.setError("Not empty");
            return false;
        } else {
            bedroomName.setError(null);
            return true;
        }
    }

    public boolean validationRentPrice() {
        EditText rentPrice = findViewById(R.id.rentPrice);
        String value = rentPrice.getText().toString();
        if (value.isEmpty()) {
            rentPrice.setError("Not empty");
            return false;
        } else {
            rentPrice.setError(null);
            return true;
        }
    }

    public boolean validationNameReporter() {
        EditText nameReporter = findViewById(R.id.nameReporter);
        String value = nameReporter.getText().toString();
        if (value.isEmpty()) {
            nameReporter.setError("Not empty");
            return false;
        } else {
            nameReporter.setError(null);
            return true;
        }
    }
}