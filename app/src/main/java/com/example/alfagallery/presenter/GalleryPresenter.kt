package com.example.alfagallery.presenter

import android.net.Uri
import android.util.Log
import com.example.alfagallery.model.Firebase
import com.example.alfagallery.IGalleryView
import com.example.alfagallery.view.recycler.IViewHolder
import com.example.alfagallery.model.Photo
import com.google.android.gms.tasks.OnSuccessListener

class GalleryPresenter(val view: IGalleryView) : BasePhotoPresenter {
    private val CLASS_TAG = "RecyclerViewPresenter"

    private var photoList: ArrayList<Photo> = arrayListOf()
    private var firebase = Firebase()
    private var storageReference = firebase.getStorageReference()

    fun getPhotos() {
        storageReference.child("images").listAll()
            .addOnSuccessListener { listResult ->
            run {
                photoList.clear()
                listResult.items.forEach { photoList.add(Photo(it.path)) }
                view.notifyDataChanged()
            }
        }
    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]

        storageReference.child(photoModel.url).downloadUrl.addOnSuccessListener { source -> iViewHolder.setImageOne(source) }
    }

    override fun getItemCount() = photoList.size

    override fun clicked(pos: Int) = view.openImage(photoList[pos].url)
}