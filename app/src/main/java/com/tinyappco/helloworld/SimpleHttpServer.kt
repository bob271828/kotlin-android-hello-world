package com.tinyappco.helloworld

import fi.iki.elonen.NanoHTTPD
import java.io.File

class SimpleHttpServer(port: Int) : NanoHTTPD(port) {

    override fun serve(session: IHTTPSession): Response {
        val uri = session.uri
        return if (uri == "/") {
            // Serve an HTML page from a file
            val file = File("/sdcard/download/static/index.html")
            newFixedLengthResponse(Response.Status.OK, "text/html", file.inputStream(), file.length())
        } else {
            // Return a 404 not found for other routes
            newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "404 Not Found")
        }
    }
}
