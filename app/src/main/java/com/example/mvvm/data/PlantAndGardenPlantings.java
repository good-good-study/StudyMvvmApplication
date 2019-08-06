package com.example.mvvm.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class PlantAndGardenPlantings {

    @Embedded
    Plant plant;

    @Relation(parentColumn = "id", entityColumn = "plant_id")
    List<GardenPlanting> gardenPlantings = new ArrayList<>();
}
