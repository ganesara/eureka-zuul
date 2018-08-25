@file: JvmName("ZuulBalancer")
package home.poc.eureka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy


fun main(args: Array<String>) {
    SpringApplication.run(ZuulConfig::class.java, *args)
}

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
open class ZuulConfig
