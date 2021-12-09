package com.example.healthcalculator;

import com.example.healthcalculator.ui.indexes.IndexBodyMassActivity;
import com.example.healthcalculator.ui.indexes.IndexEnduranceCoefficientActivity;
import com.example.healthcalculator.ui.indexes.IndexFunctionalChangesActivity;
import com.example.healthcalculator.ui.indexes.IndexKerdoActivity;
import com.example.healthcalculator.ui.indexes.IndexMovementActivityActivity;
import com.example.healthcalculator.ui.indexes.IndexRobinsonActivity;
import com.example.healthcalculator.ui.indexes.IndexSkibinskiActivity;
import com.example.healthcalculator.ui.indexes.IndexVitalActivity;

import java.util.ArrayList;

public class Constants {
    public static final String ResultsValue = "results";
    public static final String IndexTypeMessage = "type";
    public static final String TestNumber = "number";
    public static final String ResultsMessage = "message";
    public static final String ResultsFullMessage = "full_message";
    public static final String ResultsOk = "ok";

    public static final Class[] indexActivities = new Class[] {
            IndexBodyMassActivity.class,
            IndexMovementActivityActivity.class,
            IndexEnduranceCoefficientActivity.class,
            IndexRobinsonActivity.class,
            IndexVitalActivity.class,
            IndexSkibinskiActivity.class,
            IndexKerdoActivity.class,
            IndexFunctionalChangesActivity.class,
            MainActivity.class,
    };

    public static class IndexTypes {
        public static final int none = 0;
        public static final int body_mass = 1;
        public static final int movement_activity = 2;
        public static final int endurance_coefficient = 3;
        public static final int robinson = 4;
        public static final int vital = 5;
        public static final int skibinski = 6;
        public static final int kerdo = 7;
        public static final int functional_changes = 8;
        public static final int last = functional_changes;
    }
}
