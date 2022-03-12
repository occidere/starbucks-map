package org.occidere.starbucksmap.vo

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-12
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class StoreTime(
    @JsonAlias("store_time_day")
    val day: Int, // 11
    @JsonAlias("store_time_week")
    val week: Int, // 6
    @JsonAlias("store_time_week_str")
    val weekStr: String, // FRI
    @JsonProperty("store_opentime")
    val storeOpenTime: String // 0700-2100
)

/*
{
    "mon": null,
    "tue": null,
    "wed": null,
    "thur": null,
    "fri": null,
    "sat": null,
    "sun": null,
    "in_store_type": null,
    "in_biz_cd": null,
    "target": null,
    "store_time_day": "11",
    "store_time_week": "6",
    "store_time_week_str": "FRI",
    "store_opentime": "0700-2100",
    "store_time_hlytag": "1"
}
 */