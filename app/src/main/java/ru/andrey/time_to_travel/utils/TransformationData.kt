package ru.andrey.time_to_travel.utils

object TransformationData {
    fun convertDatePublished(dateString: String): String {
        val date = dateString.substring(2..9)
        val time = dateString.substring(11..15)
        return "$date $time"
    }
}