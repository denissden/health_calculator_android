package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;

public class IndexMovementActivityActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_movement_activity); // --
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.movement_activity; // --
    }

    @Override
    public float calculateIndex(){
        EditText steps_text = findViewById(R.id.edit_text_steps);
        float steps = Utilities.FloatSafe(steps_text.getText().toString());

        return steps;
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_movement_activity_diagnose); // --
        if (Result < 5000) setResultStatus(false, diagnoses[0]);
        else if (Result < 10000) setResultStatus(true, diagnoses[1]);
        else if (Result < 12000) setResultStatus(true, diagnoses[2]);
        else setResultStatus(true, diagnoses[3]);
        // --
        ResultFullMessage = getStringFromResource(R.string.text_index_movement_activity_result);
    }
}