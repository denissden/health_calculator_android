package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;

public class IndexEnduranceCoefficientActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_endurance_coefficient); // --
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.endurance_coefficient; // --
    }

    @Override
    public float calculateIndex(){
        EditText hbpm_text = findViewById(R.id.edit_text_heart_beats_per_minute);
        EditText sbp_text = findViewById(R.id.edit_text_systolic_blood_pressure);
        EditText dbp_text = findViewById(R.id.edit_text_diastolic_blood_pressure);
        float hbpm = Utilities.FloatSafe(hbpm_text.getText().toString());
        float sbp = Utilities.FloatSafe(sbp_text.getText().toString());
        float dbp = Utilities.FloatSafe(dbp_text.getText().toString());

        if (sbp - dbp == 0) return Float.NaN;

        return (hbpm * 10) / (sbp - dbp);
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_endurance_coefficient_diagnose); // --
        if (Result < 14) setResultStatus(true, diagnoses[0]);
        else if (Result < 18) setResultStatus(true, diagnoses[1]);
        else setResultStatus(false, diagnoses[2]);
        // --
        ResultFullMessage = getStringFromResource(R.string.text_index_endurance_coefficient_result);
    }
}