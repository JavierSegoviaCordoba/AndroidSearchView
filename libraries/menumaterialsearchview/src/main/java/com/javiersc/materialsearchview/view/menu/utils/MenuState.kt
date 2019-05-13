package com.javiersc.materialsearchview.view.menu.utils

import android.os.Parcel
import android.os.Parcelable
import android.preference.Preference

internal class MenuState(superState: Parcelable?) : Preference.BaseSavedState(superState) {
    var isOpen: Boolean = false

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeByte((if (isOpen) 1 else 0).toByte())
    }
}