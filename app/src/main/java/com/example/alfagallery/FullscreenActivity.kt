package com.example.alfagallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alfagallery.presenter.SinglePhotoPresenter
import kotlinx.android.synthetic.main.activity_fullscreen.*
import com.example.alfagallery.R

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {

    private lateinit var presenter: SinglePhotoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen)

        presenter = SinglePhotoPresenter(fullscreen_content)
        presenter.showImage(intent.getStringExtra("image_url"))
    }
}
