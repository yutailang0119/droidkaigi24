package com.jetbrains.workshop

import java.io.File

actual fun persistString(key: String, value: String) {
    val file = File("${key}.txt")
    file.writeText(value)
}

actual fun restoreString(key: String): String {
    return File("${key}.txt").readText()
}