package com.example.mvvm.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(
        tableName = "garden_plantings",
        foreignKeys = {
                @ForeignKey(
                        entity = Plant.class,
                        parentColumns = "id",
                        childColumns = "plant_id"
                )
        },
        indices = {@Index("plant_id")}
)
public class GardenPlanting {

    @ColumnInfo(name = "plant_id")
    String plantId;
    @ColumnInfo(name = "plant_date")
    private Calendar plantDate;
    @ColumnInfo(name = "last_watering_date")
    private Calendar lastWateringDate;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long gardenPlantingId;
}
