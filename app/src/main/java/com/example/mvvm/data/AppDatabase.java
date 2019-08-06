package com.example.mvvm.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import com.example.mvvm.utilities.Constants;
import com.example.mvvm.workers.SeedDatabaseWorker;

@Database(entities = {
        GardenPlanting.class,
        Plant.class
},
        version = 1,
        exportSchema = false)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GardenPlantingDao gardenPlantingDao();

    public abstract PlantDao plantDao();

    private static AppDatabase instance;

    public synchronized static AppDatabase getInstance(Context context) {
        return instance == null ? buildDatabase(context) : instance;
    }

    private static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, Constants.DATABASE_NAME)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        WorkRequest request = new OneTimeWorkRequest.Builder(SeedDatabaseWorker.class).build();
                        WorkManager.getInstance(context).enqueue(request);
                    }
                }).build();
    }


}
