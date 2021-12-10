package com.example.healthcalculator.ui.indexes;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.CellSignalStrengthGsm;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.healthcalculator.Constants;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;
import com.example.healthcalculator.Values;
import com.example.healthcalculator.databinding.FragmentIndexesBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class IndexesFragment extends Fragment implements View.OnClickListener {

    private IndexesViewModel indexesViewModel;
    private FragmentIndexesBinding binding;
    private Spinner spinner_sex;

    int[] button_ids = new int[] {
            R.id.button_index_1,
            R.id.button_index_2,
            R.id.button_index_3,
            R.id.button_index_4,
            R.id.button_index_5,
            R.id.button_index_6,
            R.id.button_index_7,
            R.id.button_index_8,
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        indexesViewModel =
                new ViewModelProvider(this).get(IndexesViewModel.class);

        binding = FragmentIndexesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<Button> allButtons = new ArrayList<>();

        allButtons.add(binding.buttonIndex1);
        allButtons.add(binding.buttonIndex2);
        allButtons.add(binding.buttonIndex3);
        allButtons.add(binding.buttonIndex4);
        allButtons.add(binding.buttonIndex5);
        allButtons.add(binding.buttonIndex6);
        allButtons.add(binding.buttonIndex7);
        allButtons.add(binding.buttonIndex8);


        for (Button b : allButtons){
            b.setOnClickListener(this);
        }

        spinner_sex = binding.spinnerSex;
        spinner_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        EditText age_text = getActivity().findViewById(R.id.edit_text_age);
        Float age = Utilities.FloatSafe(age_text.getText().toString());
        if (age.isNaN() || age.isInfinite()) return;
        Values.Age = age;

        int button_id = v.getId();
        int activityIndex = Arrays.asList(button_ids).indexOf(button_id);

        int i = 0;
        int found = -1;
        for (int id : button_ids){

            if (id == button_id) {
                found = i;
                break;
            }
            i++;
        }
        if (found != -1) {
            Intent intent = new Intent(this.getActivity(), Constants.indexActivities[found]);
            startActivity(intent);
        }
    }
}