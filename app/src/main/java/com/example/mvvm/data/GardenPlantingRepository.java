package com.example.mvvm.data;

import androidx.lifecycle.LiveData;

import java.util.List;

public class GardenPlantingRepository {
    private GardenPlantingDao gardenPlantingDao;
    private static GardenPlantingRepository instance;

    private GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }

    public void createGardenPlanting(String plantId) {
        GardenPlanting gardenPlanting = new GardenPlanting();
        gardenPlanting.plantId = plantId;
        gardenPlantingDao.insertGardenPlanting(gardenPlanting);
    }

    public void removeGardenPlanting(GardenPlanting gardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting);
    }

    public LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId) {
        return gardenPlantingDao.getGardednPlantingForPlant(plantId);
    }

    public LiveData<List<GardenPlanting>> getGardenPlantings() {
        return gardenPlantingDao.getGardenPlantings();
    }

    public LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return gardenPlantingDao.getPlantAndGardenPlantings();
    }

    public synchronized static GardenPlantingRepository getInstance(GardenPlantingDao gardenPlantingDao) {
        return instance == null ? new GardenPlantingRepository(gardenPlantingDao) : instance;
    }
}
