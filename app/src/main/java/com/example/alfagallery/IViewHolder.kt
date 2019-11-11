package com.example.alfagallery

import android.net.Uri
import android.view.View

interface IViewHolder {
    fun setImageOne(source: Uri?)
    fun getPos(): Int
    fun onClick(v: View?)
}