package org.occidere.starbucksmap.processor

import org.elasticsearch.action.bulk.BulkRequest
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.support.WriteRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.common.xcontent.XContentType
import org.occidere.starbucksmap.enum.Sido
import org.occidere.starbucksmap.service.StarbucksApiService
import org.occidere.starbucksmap.utils.JacksonUtils
import org.occidere.starbucksmap.vo.StarbucksStore
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import kotlin.system.measureTimeMillis

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-12
 */
@Component
class StarbucksStoreProcessor(
    private val starbucksApiService: StarbucksApiService,
    private val restHighLevelClient: RestHighLevelClient
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun run(sido: Sido = Sido.SEOUL): Unit = measureTimeMillis {
        log.info("$sido processor started")
        getStarbucksStores(sido)
            .toIndexRequests()
            .toBulkRequest()
            .doBulkSync()
    }.let { log.info("$sido processor finished ($it ms)") }

    private fun getStarbucksStores(sido: Sido): Sequence<StarbucksStore> {
        lateinit var starbucksStores: Sequence<StarbucksStore>
        measureTimeMillis {
            log.info("Starbucks API call started")
            starbucksStores = starbucksApiService.getStores(sido.code)
                .flatMap {
                    starbucksApiService.createStarbucksStores(it, starbucksApiService.getStoreTime(it.sBizCode))
                }.asSequence()
        }.let { log.info("Starbucks API call finished ($it ms)") }
        return starbucksStores
    }

    private fun Sequence<StarbucksStore>.toIndexRequests() = map {
        IndexRequest("starbucks-store-${it.dateTime}")
//            .type("_doc")
            .id(it.sCode)
            .source(JacksonUtils.OBJECT_MAPPER.writeValueAsString(it), XContentType.JSON)
    }

    private fun Sequence<IndexRequest>.toBulkRequest() = BulkRequest()
        .also { it.refreshPolicy = WriteRequest.RefreshPolicy.IMMEDIATE }
        .also { bulk -> forEach { bulk.add(it) } }

    private fun BulkRequest.doBulkSync(): Unit = measureTimeMillis {
        log.info("Bulk sync started (size: ${this.requests().size})")
        restHighLevelClient.bulk(this, RequestOptions.DEFAULT)
            .let { bulkResponse ->
                if (bulkResponse.hasFailures()) {
                    log.error("Bulk has failures: {}", bulkResponse.buildFailureMessage())
                } else {
                    log.info("Bulk finished (took {}ms)", bulkResponse.took.millis)
                }
            }
    }.let { log.info("Bulk sync finished ($it ms)") }
}