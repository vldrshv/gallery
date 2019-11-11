package com.example.alfagallery.presenter

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.alfagallery.Firebase
import com.example.alfagallery.IMainView
import com.example.alfagallery.IViewHolder
import com.example.alfagallery.Photo
import com.google.android.gms.tasks.OnSuccessListener

class GalleryPresenter(val view: IMainView) : BasePhotoPresenter {
    private val CLASS_TAG = "RecyclerViewPresenter"
    private var photoList: ArrayList<Photo> = arrayListOf()
    private var firebase = Firebase()
    private var storageReference = firebase.getStorageReference()

    fun getPhotos() {
        val list: ArrayList<Photo> = arrayListOf()
        storageReference.child("images").listAll()
            .addOnSuccessListener { listResult ->
            run {
                listResult.items.forEach { list.add(Photo(it.path)) }
                photoList.clear()
                photoList.addAll(list)
                photoList.forEach { println(it) }
                view.notifyDataChanged()
            }
        }

    }

    override fun bindView(iViewHolder: IViewHolder) {
        val position = iViewHolder.getPos()
        val photoModel = photoList[position]

        val ref = storageReference.child(photoModel.url)
        ref.downloadUrl
            .addOnSuccessListener(object : OnSuccessListener<Uri> {
                override fun onSuccess(p0: Uri?) {
                    iViewHolder.setImageOne(p0)
                }
            });
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun clicked(pos: Int) {
        view.openImage(photoList[pos].url)
        Log.i(CLASS_TAG, "open image")
    }//viewState.openImage(photoList[pos].id)
}