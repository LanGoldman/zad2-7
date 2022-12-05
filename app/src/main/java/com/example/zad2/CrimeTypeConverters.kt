package com.example.zad2

import java.util.Date
import java.util.UUID

class CrimeTypeConverters {
    @androidx.room.TypeConverter
    fun fromDate(date:Date?):Long?{
        return date?.time
    }
    @androidx.room.TypeConverter
    fun toDate(millisSinceEpoch:Long?): Date?
    {
        return millisSinceEpoch?.let {
            Date(it)
        }
    }
    @androidx.room.TypeConverter
    fun toUUID(uuid:String?) : UUID? {
        return UUID.fromString(uuid)
    }
    @androidx.room.TypeConverter
    fun fromUUTD(uuid: UUID?) : String?{
        return uuid?.toString()
    }
}