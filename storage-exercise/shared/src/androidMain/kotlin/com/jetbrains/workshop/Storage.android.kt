package com.jetbrains.workshop

import java.io.File

val context get() = ContextHelper.currentContext!!
actual fun persistString(key: String, value: String) {
    val file = File(context.getFilesDir(),"${key}.txt")
    file.writeText(value)
}

actual fun restoreString(key: String): String {
    return File(context.getFilesDir(),"${key}.txt").readText()
}