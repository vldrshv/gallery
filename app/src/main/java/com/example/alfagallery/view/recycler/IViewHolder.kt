package com.example.alfagallery.view.recycler

import android.net.Uri
import android.view.View

interface IViewHolder {
    fun setImageOne(source: Uri?)
    fun getPos(): Int
    fun onClick(v: View?)
}