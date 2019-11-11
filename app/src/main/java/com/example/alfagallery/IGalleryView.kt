package com.example.alfagallery

interface IGalleryView {
    fun notifyDataChanged()
    fun openImage(url: String)
}
