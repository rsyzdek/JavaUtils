package pl.tamides

import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

fun File.writeText(text: String, overwriteFile: Boolean = false) {
    try {
        if (!this.exists()) {
            val created = this.createNewFile()

            if (!created) {
                throw IOException("Can't create file")
            }
        }

        with(FileOutputStream(this, !overwriteFile)) {
            write(text.toByteArray())
            close()
        }
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}