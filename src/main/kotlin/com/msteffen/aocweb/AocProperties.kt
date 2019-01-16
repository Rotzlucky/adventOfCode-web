package com.msteffen.aocweb

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("aoc")
class AocProperties {

    lateinit var adventOfCodeBaseUrl: String
    lateinit var cssPath: String
    val i18n = I18N()

    class I18N {
        lateinit var title: String
        lateinit var subTitle: String
        var day: String? = null
        var linkToPuzzleDescriptionText: String? = null
    }
}