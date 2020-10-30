package com.learnings.github.pr.utils

import android.text.TextUtils
import java.text.SimpleDateFormat

object AppUtils {

    private const val APP_DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    fun getDateInMillis(dateString: String): Long {
        if (TextUtils.isEmpty(dateString)) {
            return 0
        }
        val inputFormat = SimpleDateFormat(APP_DEFAULT_DATE_FORMAT)
        val date = inputFormat.parse(dateString)
        return date?.time ?: 0
    }
}