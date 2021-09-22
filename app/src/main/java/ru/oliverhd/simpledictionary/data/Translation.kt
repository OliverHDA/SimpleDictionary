package ru.oliverhd.simpledictionary.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import ru.oliverhd.simpledictionary.data.ResponseData

@Parcelize
data class Translation(
@SerializedName ("responseData") val responseData: ResponseData
) : Parcelable
