package org.occidere.starbucksmap.configuration;

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-12
 */
@Configuration
@EnableElasticsearchRepositories
class ElasticsearchConfiguration(
    @Value("\${es.endpoint:localhost:9200}")
    private val esEndpoint: String,
    @Value("\${es.username:elastic}")
    private val username: String,
    @Value("\${es.password:elastic}")
    private val password: String
) : AbstractElasticsearchConfiguration() {
    override fun elasticsearchClient(): RestHighLevelClient =
        RestClients.create(
            ClientConfiguration.builder()
                .connectedTo(esEndpoint)
                .withSocketTimeout(10_000)
                .withConnectTimeout(10_000)
                .withBasicAuth(username, password)
                .build()
        ).rest()
}