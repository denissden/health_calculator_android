package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;

public class IndexKerdoActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_kerdo); // --
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.kerdo; // --
    }

    @Override
    public float calculateIndex(){
        EditText hbpm_text = findViewById(R.id.edit_text_heart_beats_per_minute);
        EditText dbp_text = findViewById(R.id.edit_text_diastolic_blood_pressure);
        float hbpm = Utilities.FloatSafe(hbpm_text.getText().toString());
        float dbp = Utilities.FloatSafe(dbp_text.getText().toString());

        if (dbp == 0) return Float.NaN;

        return 100 * (1 - hbpm / dbp);
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_kerdo_diagnose); // --
        if (Result > 31) setResultStatus(false, diagnoses[0]);
        else if (Result > 16) setResultStatus(false, diagnoses[1]);
        else if (Result > -15) setResultStatus(true, diagnoses[2]);
        else if (Result > -30) setResultStatus(false, diagnoses[3]);
        else setResultStatus(false, diagnoses[4]);
        // --
        ResultFullMessage = getStringFromResource(R.string.text_index_kerdo_result);
    }
}