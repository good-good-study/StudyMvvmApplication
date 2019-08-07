package com.example.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.data.GardenPlanting;
import com.example.mvvm.data.GardenPlantingRepository;
import com.example.mvvm.data.Plant;
import com.example.mvvm.data.PlantRepository;

public class PlantDetailViewModel extends ViewModel {
    private GardenPlantingRepository gardenPlantingRepository;
    public PlantRepository plantRepository;
    private String plantId;

    public LiveData<Boolean> isPlanted;
    public LiveData<Plant> plant;

    public PlantDetailViewModel(PlantRepository plantRepository, GardenPlantingRepository gardenPlantingRepository, String plantId) {
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantRepository = plantRepository;
        this.plantId = plantId;

        LiveData<GardenPlanting> gardenPlantingForPlant = gardenPlantingRepository.getGardenPlantingForPlant(plantId);
//        isPlanted =
        plant = plantRepository.getPlant(plantId);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }
}
