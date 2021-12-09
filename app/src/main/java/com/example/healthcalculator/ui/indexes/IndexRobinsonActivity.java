package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;

public class IndexRobinsonActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_robinson); // --
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.robinson; // --
    }

    @Override
    public float calculateIndex(){
        EditText hbpm_text = findViewById(R.id.edit_text_heart_beats_per_minute);
        EditText sbp_text = findViewById(R.id.edit_text_systolic_blood_pressure);
        float hbpm = Utilities.FloatSafe(hbpm_text.getText().toString());
        float sbp = Utilities.FloatSafe(sbp_text.getText().toString());

        return (hbpm * sbp) / 100;
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_robinson_diagnose); // --
        if (Result < 74) setResultStatus(false, diagnoses[0]);
        else if (Result < 80) setResultStatus(true, diagnoses[1]);
        else if (Result < 90) setResultStatus(true, diagnoses[2]);
        else if (Result < 100) setResultStatus(true, diagnoses[3]);
        else setResultStatus(false, diagnoses[4]);
        // --
        ResultFullMessage = getStringFromResource(R.string.text_index_robinson_result);
    }
}