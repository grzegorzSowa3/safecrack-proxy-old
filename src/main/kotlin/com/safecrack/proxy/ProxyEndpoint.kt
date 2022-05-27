package com.safecrack.proxy

import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.net.URISyntaxException
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping
class ProxyEndpoint(
    private val restTemplate: RestTemplate,
) {

    @RequestMapping("/**")
    @ResponseBody
    @Throws(URISyntaxException::class)
    fun proxy(
        @RequestBody body: String?,
        @RequestParam params: Map<String, String>,
        @RequestHeader headers: MultiValueMap<String, String>,
        method: HttpMethod,
        request: HttpServletRequest
    ): ResponseEntity<String> {
        log.info("Headers: $headers")
        log.info("Request Params: $params")
        log.info("Request Body: $body")
        return restTemplate.exchange(
            request.address(), method, body?.let { HttpEntity(body, headers) } ?: HttpEntity<String>(headers),
            String::class.java
        )
    }

    private fun HttpServletRequest.address() =
        this.requestURL.append(this.queryString?.let { "?$it" } ?: "").toString()

    companion object {
        val log by logger()
    }
}