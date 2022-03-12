package org.occidere.starbucksmap.service

import org.occidere.starbucksmap.vo.StarbucksStore
import org.occidere.starbucksmap.vo.Store
import org.occidere.starbucksmap.vo.StoreTime
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-11
 */
@Service
class StarbucksApiService(private val webClient: WebClient) {

    private val storeUri = "/getStore.do"
    private val storeTimeUri = "/getStoreTime.do"

    fun getStores(sidoCode: String = "01", size: Int = 1000): List<Store> = webClient.post()
        .uri(storeUri)
        .body(
            BodyInserters.fromFormData("p_sido_cd", sidoCode)
                .with("iend", "$size") // default: 1000
                .with("in_biz_cd", "")
                .with("set_date", "")
        ).retrieve()
        .blockingMonoGet()

    fun getStoreTime(sBizCode: String): List<StoreTime> = webClient.post()
        .uri(storeTimeUri)
        .body(
            BodyInserters.fromFormData("in_biz_cd", sBizCode)
                .with("in_store_type", "C")
        ).retrieve()
        .blockingMonoGet()

    fun createStarbucksStores(store: Store, storeTimes: List<StoreTime>) = storeTimes.map {
        StarbucksStore(
            sCode = store.sCode,
            sName = store.sName,
            tel = store.tel ?: "",
            fax = store.fax ?: "",
            sidoCode = store.sidoCode,
            sidoName = store.sidoName,
            gugunCode = store.gugunCode ?: "",
            gugunName = store.gugunName ?: "",
            addr = store.addr ?: "",
            sBizCode = store.sBizCode,
            defaultImage = "https://image.istarbucks.co.kr/${store.defaultImage}",
            openDt = store.openDt ?: "",
            doroAddress = store.doroAddress ?: "",
            storeAreaCode = store.storeAreaCode ?: "",
            lat = store.lat,
            lot = store.lot,
            day = it.day,
            weekStr = it.weekStr,
            storeOpenTime = it.storeOpenTime
        )
    }


    private inline fun <reified T : Any> ResponseSpec.blockingMonoGet(key: String = "list") =
        bodyToMono(object : ParameterizedTypeReference<Map<String, List<T>>>() {})
            .map { it.getOrDefault(key, emptyList()) }
            .block()!!
}