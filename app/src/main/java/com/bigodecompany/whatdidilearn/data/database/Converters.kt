package com.bigodecompany.whatdidilearn.data.database

import androidx.room.TypeConverter
import com.bigodecompany.whatdidilearn.entities.UnderstandingLevel

class Converters {
    @TypeConverter
    fun fromUnderstandingLevel(understandingLevel: UnderstandingLevel): String {
        return understandingLevel.name
    }

    @TypeConverter
    fun toUnderstandingLevel(understandingLevel: String): UnderstandingLevel {
        return UnderstandingLevel.valueOf(understandingLevel)
    }
}
