package com.example.mvvm.utilities;

import android.content.Context;

import com.example.mvvm.data.AppDatabase;
import com.example.mvvm.data.GardenPlantingRepository;
import com.example.mvvm.data.PlantRepository;
import com.example.mvvm.viewmodels.GardenPlantingListViewModel;
import com.example.mvvm.viewmodels.GardenPlantingListViewModelFactory;

public class InjectorUtils {

    private PlantRepository getPlantRepository(Context context) {
        return PlantRepository.getInstance(AppDatabase.getInstance(context.getApplicationContext()).plantDao());
    }

    private GardenPlantingRepository getGardenPlantingRepository(Context context) {
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context.getApplicationContext()).gardenPlantingDao());
    }

    public GardenPlantingListViewModelFactory provideGardenPlantingListViewModelFactory(Context context) {
        GardenPlantingRepository repository = getGardenPlantingRepository(context);
        return new GardenPlantingListViewModelFactory(repository);
    }

    public PlantDetailViewModelFactory providePlantDetailViewModelFactory(Context context,String plantId){
        return
    }
}
