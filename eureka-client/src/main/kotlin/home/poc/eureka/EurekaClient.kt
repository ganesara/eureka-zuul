@file: JvmName("EurekaClient")
package home.poc.eureka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


fun main(args: Array<String>) {
    SpringApplication.run(EurekaClientAopplicaiton::class.java, *args)
}

@SpringBootApplication
@RestController
@EnableEurekaClient
open class  EurekaClientAopplicaiton {


    @GetMapping("/greeting")
    fun greetings() : String = "Hello Eureka client"

}
