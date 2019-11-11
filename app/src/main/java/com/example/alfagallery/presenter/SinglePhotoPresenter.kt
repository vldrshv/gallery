package com.example.alfagallery.presenter

import android.net.Uri
import android.widget.ImageView
import com.example.alfagallery.Firebase
import com.squareup.picasso.Picasso

class SinglePhotoPresenter(val view: ImageView) {
    private var firebase = Firebase()
    private var storageReference = firebase.getStorageReference()

    fun showImage(url: String) {
        val ref = storageReference.child(url)
        ref.downloadUrl.addOnSuccessListener { p0 -> Picasso.get().load(p0).into(view) }
    }
}