package com.example.alfagallery

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.alfagallery.presenter.GalleryPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView {

    private lateinit var galleryPresenter: GalleryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newPhoto.setOnClickListener { openAddPhotoActivity() }
        galleryPresenter = GalleryPresenter(this)

        initRecycler()
        galleryPresenter.getPhotos()
    }
    private fun initRecycler() {
        gallery_view.layoutManager = GridLayoutManager(this, 2)
        gallery_view.adapter = MyAdapter(galleryPresenter)
    }

    override fun notifyDataChanged() {
        val myAdapter = gallery_view.adapter
        myAdapter!!.notifyDataSetChanged()
    }

    private fun openAddPhotoActivity() {
        val intent = Intent(this, PhotoChooseActivity::class.java)
        startActivity(intent)
    }

    override fun openImage(url: String) {
            val intent = Intent(this, FullscreenActivity::class.java)
            intent.putExtra("image_url", url)
            startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        galleryPresenter.getPhotos()
        notifyDataChanged()
    }
}
