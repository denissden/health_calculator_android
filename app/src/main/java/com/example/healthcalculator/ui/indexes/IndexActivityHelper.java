package com.example.healthcalculator.ui.indexes;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcalculator.Constants;

public class IndexActivityHelper extends AppCompatActivity{
    public int IndexType = Constants.IndexTypes.none;
    public String ResultMessage = "You did not configure intent message";
    public String ResultFullMessage = "You did not configure intent full message";
    public boolean ResultOk = false;
    public float Result = Float.NaN;

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
        Intent intent = new Intent(this, IndexResultsActivity.class);
        Float index = calculateIndex();
        Result = index;
        if (index.isNaN() || index.isInfinite()) {
            Toast.makeText(getApplicationContext(), "Некорректный ввод",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        validateResult();
        intent.putExtra(Constants.ResultsValue, index);
        intent.putExtra(Constants.IndexTypeMessage, IndexType);
        intent.putExtra(Constants.ResultsMessage, ResultMessage);
        intent.putExtra(Constants.ResultsFullMessage, ResultFullMessage);
        intent.putExtra(Constants.ResultsOk, ResultOk);
        startActivity(intent);
    }

    public float calculateIndex(){
        return Float.NaN;
    }

    public void validateResult(){

    }

    public void setResultStatus(boolean status, String message){
        ResultOk = status;
        ResultMessage = message;
    }

    public String getStringFromResource(int id){
        return getResources().getString(id);
    }

    public String[] getStringArrayFromResource(int id){
        return getResources().getStringArray(id);
    }
}
