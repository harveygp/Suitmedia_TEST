package com.example.suitmedia.presentasion.screen1

fun CheckPalindrom(num : String): String {

    val originalString = num
    var reverseString = ""
    var length = originalString.length

    var str = originalString
    str = str.replace("\\s".toRegex(), "")

    for (i in (length - 1) downTo 0) {
        if(i.equals(" ")) {
            continue
        } else {
            reverseString += originalString[i]
        }
    }

    var rev = reverseString.replace("\\s".toRegex(), "")

    println(str)
    println(rev)

    return if (str.equals(rev, ignoreCase = true)) {
        "True"
    } else {
        "False"
    }
}