package com.example.financasemcasal.database.converter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class InstantConverter {

    @TypeConverter
    fun fromTimesTampToInstant(value: String?): Instant? {
        return value?.let {
            Instant.parse(it)
        }
    }

    @TypeConverter
    fun fromInstantToTimestamp(value: Instant): String? {
        return value.epochSeconds.toString()
    }
//    @RequiresApi(Build.VERSION_CODES.O)
//    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    @TypeConverter
//    fun fromTimestamp(value: String?): LocalDateTime? {
//        return value?.let {
//            return formatter.parse(value, LocalDateTime::from)
//        }
//    }
//    @RequiresApi(Build.VERSION_CODES.O)
//    @TypeConverter
//    fun dateToTimestamp(date: LocalDateTime?): String? {
//        return date?.format(formatter)
//    }

}