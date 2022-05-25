package com.safecrack.proxy

import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.net.URISyntaxException
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping
class ProxyEndpoint(
    private val restTemplate: RestTemplate,
    private val server: String = "localhost",
    private val port: Int = 8080,
) {

    @RequestMapping("/**")
    @ResponseBody
    @Throws(URISyntaxException::class)
    fun proxy(
        @RequestBody body: String?,
        @RequestParam requestParams: Map<String, String>,
        @RequestHeader headers: MultiValueMap<String, String>,
        method: HttpMethod,
        request: HttpServletRequest
    ): ResponseEntity<String> {
        val uri = URI("http", null, server, port, request.requestURI, request.queryString, null)
        return restTemplate.exchange(
            uri, method, body?.let { HttpEntity(body) },
            String::class.java
        )
    }
}