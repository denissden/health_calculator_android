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

import com.example.healthcalculator.R;
import com.example.healthcalculator.Utilities;
import com.example.healthcalculator.Values;
import com.example.healthcalculator.databinding.FragmentIndexesBinding;

import java.util.ArrayList;

public class IndexesFragment extends Fragment implements View.OnClickListener {

    private IndexesViewModel indexesViewModel;
    private FragmentIndexesBinding binding;
    private Spinner spinner_sex;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        indexesViewModel =
                new ViewModelProvider(this).get(IndexesViewModel.class);

        binding = FragmentIndexesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        ArrayList<Button> allButtons = new ArrayList<Button>();

        allButtons.add(root.findViewById(R.id.button_body_mass));

        for (View b : allButtons){
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
        Intent intent = new Intent(this.getActivity(), IndexBodyMassActivity.class);
        startActivity(intent);
    }
}