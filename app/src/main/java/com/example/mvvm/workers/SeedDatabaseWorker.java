package com.example.mvvm.workers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.mvvm.data.AppDatabase;
import com.example.mvvm.data.Plant;
import com.example.mvvm.utilities.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class SeedDatabaseWorker extends Worker {
    final String TAG = this.getClass().getName();
    private Context context;

    public SeedDatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            InputStream inputStream = context.getAssets().open(Constants.PLANT_DATA_FILENAME);
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            Type type = new TypeToken<List<Plant>>() {
            }.getType();
            List<Plant> plantList = new Gson().fromJson(jsonReader, type);
            AppDatabase database = AppDatabase.getInstance(context);
            database.plantDao().insertAll(plantList);
            return Result.success();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Error seeding database" + e.toString());
            return Result.failure();
        }
    }

}
