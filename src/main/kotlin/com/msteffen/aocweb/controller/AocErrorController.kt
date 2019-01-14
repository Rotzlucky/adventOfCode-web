package com.msteffen.aocweb.controller

import com.msteffen.aocweb.AocProperties
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest


@Controller
class AocErrorController(private val properties: AocProperties) : ErrorController {

    @GetMapping("/error")
    fun handleError(request: HttpServletRequest, model: Model): String {
        model["i18n"] = properties.i18n
        model["cssPath"] = properties.cssPath

        val statusCode = request.getAttribute("javax.servlet.error.status_code") as Int
        return "/error/" + statusCode.toString()
    }


    override fun getErrorPath(): String {
        return "/error"
    }
}