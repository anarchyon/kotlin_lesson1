package project.paveltoy.kotlin_lesson1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataClass(
    val id: String,
    val name: String,
    val description: String
) : Parcelable