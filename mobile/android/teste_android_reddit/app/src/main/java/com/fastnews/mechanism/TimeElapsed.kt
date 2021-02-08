package com.fastnews.mechanism

import java.util.Date

object TimeElapsed {

    private const val MULTIPLE_VALUE_TO_MILLI = 1000

    /**
     * Get the time elapsed since the given date string
     *
     * @param dateCreated the long representing the created date
     * @return the time elapsed since the date
     */
    fun getTimeElapsed(dateCreated: Long): String {
        var result = ""

        try {
            val postDate = Date()
            postDate.time = dateCreated * MULTIPLE_VALUE_TO_MILLI

            val currentDate = Date()

            val difference = getDateDifferenceToText(postDate, currentDate)
            result = buildTimeElapsedString(difference)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

    /**
     * Get the difference between two dates in days, hours, minutes and seconds
     *
     * @param startDate
     * @param endDate
     * @return
     */
    private fun getDateDifferenceToText(startDate: Date, endDate: Date): DateDifference {
        // milliseconds
        var different = Math.abs(endDate.time - startDate.time)

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24

        val elapsedDays = different / daysInMilli
        different %= daysInMilli

        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli

        val elapsedMinutes = different / minutesInMilli
        different %= minutesInMilli

        val elapsedSeconds = different / secondsInMilli

        return DateDifference(elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds)
    }

    /**
     * Builds the time elapsed string
     *
     * @param difference
     * @return
     */
    private fun buildTimeElapsedString(difference: DateDifference): String {
        return when {
            difference.days > 0 -> difference.days.toString() + " days"
            difference.hours > 0 -> difference.hours.toString() + " hours"
            else -> difference.minutes.toString() + " minutes"
        }
    }

}

class DateDifference(var days: Long, var hours: Long, var minutes: Long, var seconds: Long)

