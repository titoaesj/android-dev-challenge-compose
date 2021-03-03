package com.example.androiddevchallenge.model


import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class Dog(
    val name: String,
    val origin: String,
    val heightMale: String,
    val heightFemale: String,
    val weightMale: String,
    val weightFamale: String,
    @DrawableRes val image: Int,
    val history: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(origin)
        parcel.writeString(heightMale)
        parcel.writeString(heightFemale)
        parcel.writeString(weightMale)
        parcel.writeString(weightFamale)
        parcel.writeInt(image)
        parcel.writeString(history)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dog> {
        override fun createFromParcel(parcel: Parcel): Dog {
            return Dog(parcel)
        }

        override fun newArray(size: Int): Array<Dog?> {
            return arrayOfNulls(size)
        }
    }
}