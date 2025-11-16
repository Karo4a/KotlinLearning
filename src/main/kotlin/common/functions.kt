package common

import java.util.Locale

fun pressToContinue() {
    print("Продолжить на Enter...")
    readln()
}

fun Double.roundToString(n: Int): String {
    var formatted = String.format(Locale.US, "%.${n}f", this)
        .trimEnd('0')
    if (formatted.last() == '.') {
        formatted += "0"
    }
    return formatted
}