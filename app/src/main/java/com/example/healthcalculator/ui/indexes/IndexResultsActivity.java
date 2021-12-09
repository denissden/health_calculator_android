package com.example.healthcalculator.ui.indexes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.FileOperations;
import com.example.healthcalculator.MainActivity;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Result;

import java.text.DecimalFormat;

public class IndexResultsActivity extends AppCompatActivity {
    public int IndexType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_results);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        IndexType = intent.getExtras().getInt(Constants.IndexTypeMessage);
        boolean resultOk = intent.getExtras().getBoolean(Constants.ResultsOk);
        String message = intent.getStringExtra(Constants.ResultsMessage);
        String fullMessage = intent.getStringExtra(Constants.ResultsFullMessage);
        Float result = intent.getExtras().getFloat(Constants.ResultsValue);

        TextView before_result_text = findViewById(R.id.text_before_result);
        TextView result_text = findViewById(R.id.text_result);
        TextView before_message_text = findViewById(R.id.text_before_message);
        TextView message_text = findViewById(R.id.text_message);
        TextView full_message_text = findViewById(R.id.text_full_message);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        result_text.setText(df.format(result));
        message_text.setText(message);
        full_message_text.setText(fullMessage);

        int c;
        if (resultOk) c = ResourcesCompat.getColor(getResources(), R.color.green, null);
        else c = ResourcesCompat.getColor(getResources(), R.color.red, null);

        before_result_text.setTextColor(c);
        result_text.setTextColor(c);
        before_message_text.setTextColor(c);
        message_text.setTextColor(c);
        //full_message_text.setTextColor(c);

        Result saveResult = new Result(IndexType, result, resultOk, message);
        FileOperations.writeResult(saveResult, getApplicationContext());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void continueClick(View v){

        Intent gotoScreenVar = new Intent(this, Constants.indexActivities[IndexType]);

        if (IndexType == Constants.IndexTypes.last) {
            gotoScreenVar = new Intent(this, MainActivity.class);
            gotoScreenVar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        startActivity(gotoScreenVar);
    }
}