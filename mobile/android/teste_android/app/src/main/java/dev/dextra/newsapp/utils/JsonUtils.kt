package dev.dextra.newsapp.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import java.lang.reflect.Modifier

object JsonUtils {

    private var gson: Gson? = null

    fun getGson(): Gson {

        return gson?:let {
            val gsonBuilder = GsonBuilder()
                .excludeFieldsWithModifiers(
                    Modifier.TRANSIENT,
                    Modifier.STATIC
                )
            gson = gsonBuilder
                .create()
            return gson!!
        }
    }

    fun <T> toJson(bodyObject: T): String {
        return getGson().toJson(bodyObject)
    }
}
