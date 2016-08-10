package com.sageone.kotlinjson

/**
 * Created by neil.wilkinson on 10/08/2016.
 */
data class StringModel(val a: String,
                    val b: String = "2",
                    val c: String?,
                    val d: String? = "4") {
}

fun createDefault() = StringModel(a = "1", c = "3")
