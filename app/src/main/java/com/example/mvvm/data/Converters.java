package com.example.mvvm.data;

import androidx.room.TypeConverter;

import java.util.Calendar;

public class Converters {

    @TypeConverter
    Long alendarToDatestamp(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    @TypeConverter
    Calendar datestampToCalendar(Long value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(value);
        return calendar;
    }
}
