package com.example.alfagallery.presenter

import com.example.alfagallery.view.recycler.IViewHolder

interface BasePhotoPresenter {
    fun bindView(iViewHolder: IViewHolder)
    fun getItemCount(): Int
    fun clicked(pos: Int)
}
