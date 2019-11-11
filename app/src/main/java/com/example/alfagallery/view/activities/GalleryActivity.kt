package com.example.alfagallery.view.activities

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.alfagallery.IGalleryView
import com.example.alfagallery.view.recycler.MyAdapter
import com.example.alfagallery.R
import com.example.alfagallery.presenter.GalleryPresenter
import kotlinx.android.synthetic.main.activity_main.*

class GalleryActivity : AppCompatActivity(), IGalleryView {

    private lateinit var galleryPresenter: GalleryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newPhoto.setOnClickListener { openAddPhotoActivity() }
        galleryPresenter = GalleryPresenter(this)

        initRecycler()
        getPhotosFromServer()
    }

    private fun initRecycler() {
        val spanCount = if (isPortraitOrientation()) 2 else 3
        gallery_view.layoutManager = GridLayoutManager(this, spanCount)
        gallery_view.adapter = MyAdapter(galleryPresenter)
    }

    private fun getPhotosFromServer() {
        showImageLoading(true)
        galleryPresenter.getPhotos()
    }

    override fun notifyDataChanged() {
        val myAdapter = gallery_view.adapter
        myAdapter!!.notifyDataSetChanged()
        showImageLoading(false)
    }

    private fun openAddPhotoActivity() {
        val intent = Intent(this, PhotoChooseActivity::class.java)
        startActivity(intent)
    }

    override fun openImage(url: String) {
        val intent = Intent(this, PhotoViewActivity::class.java)
        intent.putExtra("image_url", url)
        startActivity(intent)
    }

    private fun showImageLoading(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }
    private fun isPortraitOrientation(): Boolean {
        return this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

    override fun onResume() {
        super.onResume()
        showImageLoading(true)
        galleryPresenter.getPhotos()
        notifyDataChanged()
        showImageLoading(false)
    }


}
