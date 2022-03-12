package org.occidere.starbucksmap.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-11
 */
class JacksonUtils {

    companion object {
        public val OBJECT_MAPPER: ObjectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }
}

