package com.safecrack.proxy

import com.safecrack.proxy.register.RegisterExchangeService
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.net.URISyntaxException


@Controller
@RequestMapping
class ProxyEndpoint(
    private val restTemplate: RestTemplate,
    private val service: RegisterExchangeService,
) {

    @RequestMapping("/**")
    @ResponseBody
    fun proxy(
        request: RequestEntity<String>,
    ): ResponseEntity<String> {
        val response = restTemplate.exchange(request, String::class.java)
        service.registerExchange(request, response)
        return response
    }
}
