package com.javiersc.materialsearchview.view.materialsearchview.utils

import android.os.Parcel
import android.os.Parcelable
import android.preference.Preference

internal class State(superState: Parcelable?) : Preference.BaseSavedState(superState) {
    var isOpen: Boolean = false
    var text: String = ""

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeByte((if (isOpen) 1 else 0).toByte())
        out.writeString(text)
    }
}