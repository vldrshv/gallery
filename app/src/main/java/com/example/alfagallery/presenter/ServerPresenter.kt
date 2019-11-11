package com.example.alfagallery.presenter

import android.app.ProgressDialog
import android.net.Uri
import com.example.alfagallery.model.Firebase
import com.example.alfagallery.IPhotoChoose
import java.util.*

// todo MOXY
class ServerPresenter (val view: IPhotoChoose? = null) {
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