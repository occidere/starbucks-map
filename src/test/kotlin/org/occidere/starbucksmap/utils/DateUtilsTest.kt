package org.occidere.starbucksmap.utils

import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-12
 */
class DateUtilsTest {

    @Test
    public fun dateTest() {
        println(LocalDate.now().withDayOfMonth(1))
    }
}