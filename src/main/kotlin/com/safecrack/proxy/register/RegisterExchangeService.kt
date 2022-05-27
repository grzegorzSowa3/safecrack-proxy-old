package com.safecrack.proxy.register

import com.safecrack.proxy.logger
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class RegisterExchangeService(
    private val client: ScannerClient
) {

    fun registerExchange(
        request: RequestEntity<String>,
        response: ResponseEntity<String>
    ) {
        log.info("Request method: ${request.method}")
        log.info("Request url: ${request.url}")
        log.info("Request headers: ${request.headers}")
        log.info("Request body: ${request.body}")
        log.info("Response status: ${response.statusCode}")
        log.info("Response headers: ${response.headers}")
        log.info("Response body: ${response.body}")
    }

    companion object {
        val log by logger()
    }
}