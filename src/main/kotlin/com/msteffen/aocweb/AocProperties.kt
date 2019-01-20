package com.msteffen.aocweb

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("aoc")
class AocProperties {
    var cssPath: String = "/css/page.css"
}