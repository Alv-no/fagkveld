package no.alv.fagkveldbackend

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.web.bind.annotation.RestController


@RestController
class IndexController : ErrorController {
    fun getErrorPath(): String? {
        return "/"
    }
}