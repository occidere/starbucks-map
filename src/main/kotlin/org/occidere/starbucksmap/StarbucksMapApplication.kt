package org.occidere.starbucksmap

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-11
 */
import org.occidere.starbucksmap.enum.Sido
import org.occidere.starbucksmap.processor.StarbucksStoreProcessor
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import kotlin.system.exitProcess

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class StarbucksMapApplication(
    private val starbucksStoreProcessor: StarbucksStoreProcessor
) : ApplicationRunner {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun run(args: ApplicationArguments?) {
        Sido.values().forEach { sido ->
            try {
                starbucksStoreProcessor.run(sido)
            } catch (e: Exception) {
                log.error("$sido processor failed", e)
            }
        }
    }

}

fun main(args: Array<String>) {
    val context = runApplication<StarbucksMapApplication>(*args)
    val exitCode = SpringApplication.exit(context)
    exitProcess(exitCode)
}