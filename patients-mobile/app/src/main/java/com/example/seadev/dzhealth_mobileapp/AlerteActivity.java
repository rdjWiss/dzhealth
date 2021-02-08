package com.example.seadev.dzhealth_mobileapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AlerteActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    Spinner listTypeAlerte;
    ImageButton btn_alerte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerte);

        listTypeAlerte = (Spinner) findViewById(R.id.type_alerte);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_alerte, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        listTypeAlerte.setAdapter(adapter);
        listTypeAlerte.setOnItemSelectedListener(this);

        btn_alerte = (ImageButton) findViewById(R.id.btn_alerte);
        btn_alerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (listTypeAlerte.getSelectedItemPosition()) {
                    //// TODO: 09/06/2017 phppppppppppppp
                    case 0:
                        Toast.makeText(AlerteActivity.this,
                                "Alerte \n a été envoyé",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(AlerteActivity.this,
                                "Alerte de disparition \n a été envoyé",
                                Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(AlerteActivity.this,
                                "Alerte de chute \n a été envoyé",
                                Toast.LENGTH_LONG).show();
                        break;
                }
                finish();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
