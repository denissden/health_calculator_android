package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;

public class IndexVitalActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_vital); // --
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.vital; // --
    }

    @Override
    public float calculateIndex(){
        EditText mass_text = findViewById(R.id.edit_text_body_mass);
        EditText lungs_volume_text = findViewById(R.id.edit_text_lungs_volume);
        float mass = Utilities.FloatSafe(mass_text.getText().toString());
        float lungs_volume = Utilities.FloatSafe(lungs_volume_text.getText().toString());

        if (mass == 0) return Float.NaN;

        return lungs_volume / mass;
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_vital_diagnose); // --
        if (Result < 51) setResultStatus(false, diagnoses[0]);
        else if (Result < 60) setResultStatus(true, diagnoses[1]);
        else setResultStatus(true, diagnoses[2]);
        // --
        ResultFullMessage = getStringFromResource(R.string.text_index_vital_result);
    }
}