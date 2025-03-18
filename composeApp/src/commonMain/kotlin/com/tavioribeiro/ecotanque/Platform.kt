package com.tavioribeiro.ecotanque

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform