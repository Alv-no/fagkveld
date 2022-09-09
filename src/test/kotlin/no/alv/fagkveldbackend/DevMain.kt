package no.alv.fagkveldbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DevMain

fun main(args: Array<String>) {
    runApplication<Main>(*args)
}
