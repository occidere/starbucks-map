package org.occidere.starbucksmap.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-12
 */
class DateUtils {

    companion object {
        public fun getAdjustedDateStr(day: Int): String = LocalDate.now()
            .withDayOfMonth(1)
            .plusDays(day.toLong() - 1)
            .format(DateTimeFormatter.ofPattern("yyyyMMdd"))
    }
}