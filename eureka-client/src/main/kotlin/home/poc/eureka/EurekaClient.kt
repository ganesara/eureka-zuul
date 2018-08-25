@file: JvmName("EurekaClient")
package home.poc.eureka

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment


fun main(args: Array<String>) {
    SpringApplication.run(EurekaClientApplicaiton::class.java, *args)
}

@SpringBootApplication
@RestController
@EnableEurekaClient
open class  EurekaClientApplicaiton {

    @Autowired
    var environment: Environment? = null

    @GetMapping("/greeting")
    fun greetings() : String = "Hello Eureka client - ${environment?.getProperty("local.server.port") ?: "NULL VALUE"}"

}
