package com.example.rental_z_native;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment {
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String property = bundle.getString("property");

        String bedroom = bundle.getString("bedroom");
        String rentPrice = bundle.getString("rentPrice");
        String nameReporter = bundle.getString("nameReporter");
        String date = bundle.getString("date");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Your rent information")
                .setMessage("Property Name : " + property + " " + "\n" + "\n"
                        + "Bedroom Name : " + bedroom + "\n" + "\n"
                        + "Rent Price : " + rentPrice + "\n" + "\n"
                        + "Name Reporter : " + nameReporter + "\n" + "\n"
                        + "Date : " + date
                )
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SuccessDialog success = new SuccessDialog();
                        success.show(getActivity().getSupportFragmentManager(), "Parameter");
                    }
                });
        return builder.create();
    }
}

