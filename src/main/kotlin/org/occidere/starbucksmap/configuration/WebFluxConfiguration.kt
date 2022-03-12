package org.occidere.starbucksmap.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-11
 */
@Configuration
class WebFluxConfiguration {

    @Bean
    fun starbucksWebClient() = WebClient.builder()
        .baseUrl("https://www.starbucks.co.kr/store")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0")
        .exchangeStrategies(
            ExchangeStrategies.builder()
                .codecs { configurer ->
                    configurer.defaultCodecs()
                        .maxInMemorySize(-1) // unlimited mem size
                }.build()
        ).build()
}