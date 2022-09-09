package no.alv.fagkveldbackend.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import no.alv.fagkveldbackend.config.ObjectMapper.Companion.objectMapper

class ObjectMapper {
    companion object {
        @Volatile
        private var objectMapper: ObjectMapper? = null

        fun objectMapper() = objectMapper ?: synchronized(this) {
            objectMapper ?: buildObjectMapper().also { objectMapper = it }
        }

        private fun buildObjectMapper(): ObjectMapper {
            val objectMapper = ObjectMapper()
            return objectMapper
        }
    }
}

fun Any.json(): String = objectMapper().writeValueAsString(this)

inline fun <reified T> String.fromJson(): T = objectMapper().readValue(this)