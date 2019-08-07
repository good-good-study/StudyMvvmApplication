package com.example.mvvm.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm.data.GardenPlantingRepository;

public class GardenPlantingListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private GardenPlantingRepository repository;

    public GardenPlantingListViewModelFactory(GardenPlantingRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GardenPlantingListViewModel(repository);
    }
}
