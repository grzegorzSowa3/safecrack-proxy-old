package com.safecrack.proxy

import org.apache.http.HttpRequest
import org.apache.http.HttpResponse
import org.apache.http.client.RedirectStrategy
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.protocol.HttpContext


internal class NoRedirectStrategy : RedirectStrategy {
    override fun isRedirected(httpRequest: HttpRequest, httpResponse: HttpResponse, httpContext: HttpContext): Boolean {
        return false
    }

    override fun getRedirect(
        httpRequest: HttpRequest,
        httpResponse: HttpResponse,
        httpContext: HttpContext
    ): HttpUriRequest {
        throw NotImplementedError()
    }
}