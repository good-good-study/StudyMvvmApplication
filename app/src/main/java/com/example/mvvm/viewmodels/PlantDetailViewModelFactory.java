package com.example.mvvm.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.data.GardenPlantingRepository;
import com.example.mvvm.data.PlantRepository;

public class PlantDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private GardenPlantingRepository gardenPlantingRepository;
    private PlantRepository plantRepository;
    private String plantId;

    public PlantDetailViewModelFactory(PlantRepository plantRepository, GardenPlantingRepository gardenPlantingRepository, String plantId) {
        this.plantRepository = plantRepository;
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantId = plantId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PlantDetailViewModel(plantRepository, gardenPlantingRepository, plantId);
    }
}
