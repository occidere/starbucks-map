package org.occidere.starbucksmap.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.occidere.starbucksmap.utils.DateUtils
import org.occidere.starbucksmap.utils.JacksonUtils
import org.springframework.data.annotation.Id

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class StarbucksStore(
    @Id
    val sCode: String, // 1509
    val sName: String, // 역삼아레나빌딩
    val tel: String, //1522-3232
    val fax: String, //02-568-3763
    val sidoCode: String, // 01
    val sidoName: String, // 서울
    val gugunCode: String, // 0101
    val gugunName: String, // 강남구
    val addr: String, // 서울특별시 강남구 역삼동 721-13 아레나빌딩
    val sBizCode: String, // 3762 (store time api 에서 사용)
    val defaultImage: String, // /upload/store/2020/09/[3762]_20200917031519_6juwr.JPG
    val openDt: String, // 20190613
    val doroAddress: String, // 서울특별시 강남구 언주로 425 (역삼동)
    val storeAreaCode: String, // A01
    val lat: String, // 37.501087
    val lot: String, // 127.043069
    val day: Int, // 11
    val weekStr: String, // FRI
    private val storeOpenTime: String // 0700-2100
) {

    val location: String = "$lat,$lot"
    val open: String = storeOpenTime.substring(0, 4)
    val close: String = storeOpenTime.substring(5)
    val createdAt: Long = System.currentTimeMillis()
    val dateTime: String = DateUtils.getAdjustedDateStr(day) // 20220311

    override fun toString() = JacksonUtils.OBJECT_MAPPER.writeValueAsString(this)!!
}
