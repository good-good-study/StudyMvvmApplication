package com.example.mvvm.data;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlantRepository {

    private PlantDao plantDao;
    private static PlantRepository instance;

    private PlantRepository(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    public synchronized static PlantRepository getInstance(PlantDao plantDao) {
        return instance == null ? new PlantRepository(plantDao) : instance;
    }

    public LiveData<List<Plant>> getPlants() {
        return plantDao.getPlants();
    }

    public LiveData<Plant> getPlant(String plantId) {
        return plantDao.getPlant(plantId);
    }

    public LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber) {
        return plantDao.getPlantsWithGrowZoneNumber(growZoneNumber);
    }
}
