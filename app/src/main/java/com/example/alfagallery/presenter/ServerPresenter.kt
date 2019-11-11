package com.example.alfagallery.presenter

import android.app.ProgressDialog
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.alfagallery.Firebase
import com.example.alfagallery.IImageUpload
import com.example.alfagallery.Photo
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

// todo MOXY
class ServerPresenter (val view: IImageUpload? = null) {
    private val CLASS_TAG = "Presenter"
    private val firebase = Firebase()

    fun uploadImageToServer(progressDialog: ProgressDialog, filePath: Uri) {
        val ref = firebase.getStorageReference()
            .child("images/" + UUID.randomUUID().toString())
        ref.putFile(filePath)
            .addOnSuccessListener {
                progressDialog.dismiss()
                view!!.showToast("Uploaded")
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                view!!.showToast("Failed " + e.message)
            }
            .addOnProgressListener { taskSnapshot ->
                val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot
                    .totalByteCount
                progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
            }
    }

}