package com.example.healthcalculator;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileOperations {
    public static Gson gson = new Gson();

    public static void writeResult(Result result, Context context) {
        String filename = result.Type + ".json";
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    context.openFileOutput(filename, Context.MODE_PRIVATE)
            );
            outputStreamWriter.write(gson.toJson(result));
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public static Result readResult(int resultType, Context context) {
        String filename = resultType + ".json";

        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return gson.fromJson(sb.toString(), Result.class);
        } catch (FileNotFoundException fileNotFound) {
            return null;
        } catch (IOException ioException) {
            return null;
        }
    }
}
