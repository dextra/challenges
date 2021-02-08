package dev.dextra.newsapp.base

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object FileUtils {

    fun readJson(path: String): String? {
        val url = FileUtils::class.java.classLoader!!.getResource(path) ?: return null

        var inputStream: InputStream? = null
        try {
            inputStream = url.openStream()
            val reader = BufferedReader(InputStreamReader(inputStream))
            var file = ""
            while (reader.ready()) {
                file += reader.readLine()
            }
            return file
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }
        return null
    }
}
