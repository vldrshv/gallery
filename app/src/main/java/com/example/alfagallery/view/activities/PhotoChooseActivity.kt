package com.example.alfagallery.view.activities

import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.alfagallery.IPhotoChoose
import com.example.alfagallery.R
import com.example.alfagallery.presenter.ServerPresenter
import kotlinx.android.synthetic.main.activity_photo_choose.*


class PhotoChooseActivity : PhotoUtilActivity(), IPhotoChoose {
    private val CLASS_TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_choose)

        presenter = ServerPresenter(this)

        initUI()
    }

    private fun initUI() {
        btnChoose.setOnClickListener { chooseImage() }
        btnUpload.setOnClickListener { uploadImage() }
        btnMakePhoto.setOnClickListener { createFileAndOpenCameraIntent() }
        imgView.setOnClickListener { openImage() }
    }

    private fun chooseImage() {
        startActivityChooseImage()
    }

    private fun uploadImage() {
        uploadImageToServer()
    }

    private fun openImage() {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        val path = filePath?.path
        filePath = Uri.parse(path?.replace("file://", "content://"))
        intent.setDataAndType(filePath, "image/*")
        startActivity(intent)
    }

    override fun showToast(message: String) {
        Toast.makeText(this@PhotoChooseActivity, message, Toast.LENGTH_SHORT).show()
    }
}
