package com.example.mvvm.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(tableName = "plants")
public class Plant {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private String plantId;

    private String name;
    private String description;
    private int growZoneNumber;
    private int wateringInterval;
    private String imageUrl;

    public boolean shouldBeWatered(Calendar since, Calendar lastWateringDate) {
        long sinceLong = since.getTimeInMillis();
        long lastLong = lastWateringDate.getTimeInMillis();
        return lastLong - sinceLong >= 7 * 24 * 60 * 60 * 1000L;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrowZoneNumber() {
        return growZoneNumber;
    }

    public void setGrowZoneNumber(int growZoneNumber) {
        this.growZoneNumber = growZoneNumber;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public void setWateringInterval(int wateringInterval) {
        this.wateringInterval = wateringInterval;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
