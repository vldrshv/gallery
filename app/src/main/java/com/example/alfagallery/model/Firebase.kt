package com.example.alfagallery.model

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Firebase {
    private val storage: FirebaseStorage = FirebaseStorage.getInstance()
    private val storageReference: StorageReference = storage.reference

    fun getStorageReference() = storageReference
}