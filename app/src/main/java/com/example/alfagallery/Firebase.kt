package com.example.alfagallery

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Firebase {
    //Firebase
    private lateinit var storage: FirebaseStorage
    private lateinit var storageReference: StorageReference


    init {
        initStorage()
    }

    private fun initStorage() {
        storage = FirebaseStorage.getInstance()
        storageReference = storage.reference
    }

    fun getStorageReference() = storageReference
}