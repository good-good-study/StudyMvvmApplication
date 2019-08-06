package com.example.mvvm.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface GardenPlantingDao {

    @Query("SELECT * FROM garden_plantings")
    LiveData<List<GardenPlanting>> getGardenPlantings();

    @Transaction
    @Query("SELECT * FROM plants")
    LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings();

    @Insert
    long insertGardenPlanting(GardenPlanting gardenPlanting);

    @Delete
    void deleteGardenPlanting(GardenPlanting gardenPlanting);
}
