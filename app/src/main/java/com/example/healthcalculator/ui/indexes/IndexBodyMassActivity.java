package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;

public class IndexBodyMassActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_body_mass);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.body_mass;
    }

    @Override
    public float calculateIndex(){
        EditText mass_text = findViewById(R.id.edit_text_body_mass);
        EditText height_text = findViewById(R.id.edit_text_body_height);
        float mass = Utilities.FloatSafe(mass_text.getText().toString());
        float height = Utilities.FloatSafe(height_text.getText().toString());

        return  mass / (height * height);
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_body_mass_diagnose);
        if (Result < 18.5) setResultStatus(false, diagnoses[0]);
        else if (Result < 25) setResultStatus(true, diagnoses[1]);
        else if (Result < 30) setResultStatus(false, diagnoses[2]);
        else if (Result < 35) setResultStatus(false, diagnoses[3]);
        else setResultStatus(false, diagnoses[4]);
        ResultFullMessage = getStringFromResource(R.string.text_index_body_mass_result);
    }
}