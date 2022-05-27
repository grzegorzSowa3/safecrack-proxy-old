package com.safecrack.proxy

import org.springframework.http.HttpMethod
import java.time.Duration

data class RegisterExchangeCommand(
    val request: Request,
    val response: Response,
)

data class Request(
    val method: HttpMethod,
    val path: String,
    val host: String,
    val headers: Map<String, String>,
    val cookies: Set<Cookie>,
    val body: String,
)


data class Response(
    val status: String,
    val cookies: Set<Cookie>,
    val body: String,
)

data class Cookie(
    val name: String,
    val domain: String,
    val path: String,
    val maxAge: Duration,
    val httpOnly: Boolean,
    val secure: Boolean,
)