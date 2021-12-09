package com.example.healthcalculator.ui.indexes;

import android.os.Bundle;
import android.widget.EditText;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;

public class IndexSkibinskiActivity extends IndexActivityHelper {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_skibinski); // --
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IndexType = Constants.IndexTypes.skibinski; // --
    }

    @Override
    public float calculateIndex(){
        EditText lv_text = findViewById(R.id.edit_text_lungs_volume);
        EditText sp_text = findViewById(R.id.edit_text_schtange_probe);
        EditText hbpm_text = findViewById(R.id.edit_text_heart_beats_per_minute);
        float lv = Utilities.FloatSafe(lv_text.getText().toString());
        float sp = Utilities.FloatSafe(sp_text.getText().toString());
        float hbpm = Utilities.FloatSafe(hbpm_text.getText().toString());

        if (hbpm == 0) return Float.NaN;

        return ((lv / 100) * sp) / hbpm;
    }

    public void validateResult(){
        String[] diagnoses = getResources().getStringArray(R.array.text_index_skibinski_diagnose); // --
        if (Result < 5) setResultStatus(false, diagnoses[0]);
        else if (Result < 10) setResultStatus(false, diagnoses[1]);
        else if (Result < 30) setResultStatus(true, diagnoses[2]);
        else if (Result < 60) setResultStatus(true, diagnoses[3]);
        else setResultStatus(true, diagnoses[4]);
        // --
        ResultFullMessage = getStringFromResource(R.string.text_index_skibinski_result);
    }
}