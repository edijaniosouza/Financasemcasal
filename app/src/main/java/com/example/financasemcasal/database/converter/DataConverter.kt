package com.example.financasemcasal.database.converter

import androidx.room.TypeConverter
import java.util.Date

class DataConverter {
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let {
            Date(it)
        }
    }
    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}