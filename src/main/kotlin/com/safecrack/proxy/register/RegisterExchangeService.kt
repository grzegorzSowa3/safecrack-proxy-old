package com.safecrack.proxy.register

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

    }
}