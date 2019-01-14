package com.msteffen.aocweb

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class NonExistingDayException(message: String = "The resource is not available") : Exception(message)