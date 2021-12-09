package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;
import com.example.healthcalculator.Values;

public class IndexFunctionalChangesActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_functional_changes); // --
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.functional_changes; // --
    }

    @Override
    public float calculateIndex(){
        EditText hbpm_text = findViewById(R.id.edit_text_heart_beats_per_minute);
        EditText dbp_text = findViewById(R.id.edit_text_diastolic_blood_pressure);
        EditText sbp_text = findViewById(R.id.edit_text_systolic_blood_pressure);
        EditText mass_text = findViewById(R.id.edit_text_systolic_blood_pressure);
        EditText height_text = findViewById(R.id.edit_text_systolic_blood_pressure);
        float hbpm = Utilities.FloatSafe(hbpm_text.getText().toString());
        float dbp = Utilities.FloatSafe(dbp_text.getText().toString());
        float sbp = Utilities.FloatSafe(sbp_text.getText().toString());
        float mass = Utilities.FloatSafe(mass_text.getText().toString());
        float height = Utilities.FloatSafe(height_text.getText().toString());

        return (float) (hbpm * 0.011 +
                        sbp * 0.014 +
                        dbp * 0.008 +
                        Values.Age * 0.014 +
                        mass * 0.009 +
                        height * 0.009 - 0.27);
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_functional_changes_diagnose); // --
        if (Result < 2.6) setResultStatus(false, diagnoses[0]);
        else if (Result < 3.09) setResultStatus(true, diagnoses[1]);
        else setResultStatus(false, diagnoses[2]);
        // --
        ResultFullMessage = getStringFromResource(R.string.text_index_functional_changes_result);
    }
}