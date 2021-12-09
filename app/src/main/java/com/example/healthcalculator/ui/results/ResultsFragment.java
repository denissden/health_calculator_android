package com.example.healthcalculator.ui.results;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthcalculator.App;
import com.example.healthcalculator.Constants;
import com.example.healthcalculator.FileOperations;
import com.example.healthcalculator.R;
import com.example.healthcalculator.Result;
import com.example.healthcalculator.databinding.FragmentResultsBinding;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.crypto.AEADBadTagException;

public class ResultsFragment extends Fragment {

    private ResultsViewModel resultsViewModel;
    private FragmentResultsBinding binding;
    public static ArrayList<Result> resultArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resultsViewModel =
                new ViewModelProvider(this).get(ResultsViewModel.class);

        binding = FragmentResultsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        resultArrayList.clear();

        for (int i = 0; i < Constants.IndexTypes.last; i++){
            Result resultAtIndex = FileOperations.readResult(i, getContext());
            if (resultAtIndex != null)
                resultArrayList.add(resultAtIndex);
        }

        String[] indexNames = new String[] {
                "None",
                getString(R.string.text_index_body_mass_short),
                getString(R.string.text_index_movement_activity_short),
                getString(R.string.text_index_endurance_coefficient_short),
                getString(R.string.text_index_robinson_short),
                getString(R.string.text_index_vital_short),
                getString(R.string.text_index_skibinski_short),
                getString(R.string.text_index_kerdo_short),
                getString(R.string.text_index_functional_changes_short),
        };

        ArrayAdapter<Result> adapter = new ArrayAdapter<Result>(getContext(), android.R.layout.simple_list_item_2, android.R.id.text1, resultArrayList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                Result item = resultArrayList.get(position);

                Resources res = getResources();

                int c;
                if (item.IsOk) c = ResourcesCompat.getColor(res, R.color.green, null);
                else c = ResourcesCompat.getColor(res, R.color.red, null);
                text2.setTextColor(c);

                text1.setText(indexNames[item.Type]);

                text2.setText(
                        String.format(res.getString(R.string.text_results_value_date),
                        item.Value,
                        item.Message,
                        item.ResultDateString
                        ));
                return view;
            }
        };

        binding.listViewResults.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}