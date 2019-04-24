package com.numerica98.pokedex.models

import android.os.Parcel
import android.os.Parcelable

data class Pokemon (
    val id:Int,
    val name:String="N/A",
    val type:String= "N/A",
    val description:String= "N/A"
) : Parcelable {
    constructor(parcel: Parcel): this(
        id= parcel.readInt(),
        name= parcel.readString(),
        type= parcel.readString(),
        description = parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeString(description)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField val CREATOR = object : Parcelable.Creator<Pokemon>{
            override fun createFromParcel(parcel: Parcel): Pokemon = Pokemon(parcel)
            override fun newArray(size: Int): Array<Pokemon?> = arrayOfNulls(size)
        }
    }

}