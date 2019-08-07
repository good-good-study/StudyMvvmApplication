package com.example.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.data.GardenPlanting;
import com.example.mvvm.data.GardenPlantingRepository;
import com.example.mvvm.data.PlantAndGardenPlantings;

import java.util.List;

public class GardenPlantingListViewModel extends ViewModel {

    public LiveData<List<GardenPlanting>> gardenPlantings;
    public LiveData<List<PlantAndGardenPlantings>> plantAndGardenPlantings;

    public GardenPlantingListViewModel(GardenPlantingRepository gardenPlantingRepository) {
        gardenPlantings = gardenPlantingRepository.getGardenPlantings();
        plantAndGardenPlantings = gardenPlantingRepository.getPlantAndGardenPlantings();
    }


}
