package com.jetbrains.workshop

import kotlinx.browser.window

actual fun persistString(key: String, value: String) {
    window.localStorage.setItem(key, value)
}

actual fun restoreString(key: String): String {
    return window.localStorage.getItem(key) ?: ""
}