@file: JvmName("EurekaConsumer")
package home.poc.eureka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


fun main(args: Array<String>) {
    SpringApplication.run(EurekaConsumerApplicaiton::class.java, *args)
}


@FeignClient("spring-cloud-eureka-client")
interface GreetingClient {

    @RequestMapping("/greeting")
    fun greetings() : String

}


@SpringBootApplication
@EnableFeignClients
@Controller
open class EurekaConsumerApplicaiton {

    @Autowired
    lateinit var greetingClient: GreetingClient


    @GetMapping("get-greetings")
    fun getGreeting(model: Model) : String {
        model.addAttribute("greeting", greetingClient.greetings())

        return "greetings-view"
    }
}