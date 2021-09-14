package ru.oliverhd.simpledictionary.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseData(
    @SerializedName("translatedText") val translatedText: String
) : Parcelable
