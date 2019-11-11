package com.example.alfagallery.view.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.alfagallery.presenter.ServerPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photo_choose.*
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

open class PhotoUtilActivity : AppCompatActivity() {
    private val CLASS_TAG = "PhotoUtilActivity"
    private val REQUEST_TAKE_PHOTO = 71
    private val PICK_IMAGE_REQUEST = 1

    protected var filePath: Uri? = null

//    @InjectPresenter
    protected lateinit var presenter: ServerPresenter

    // -
    protected fun createFileAndOpenCameraIntent() {
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(pictureIntent.resolveActivity(packageManager) != null) {
            var photoFile: File? = null
            try {
                photoFile = createImageFile()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e(CLASS_TAG, "Cannot create file source")
            }
            if (photoFile != null) {
                val photoURI = FileProvider.getUriForFile(this, "${packageName}.provider", photoFile)
                pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                startActivityForResult(pictureIntent, REQUEST_TAKE_PHOTO)
            }
        }
    }

    protected fun uploadImageToServer() {
        if (filePath != null) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()
            presenter.uploadImageToServer(progressDialog, filePath!!)
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val prefix = "IMG_${timeStamp}_"
        val suffix = ".jpg"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        val image = File.createTempFile(prefix, suffix, storageDir)

        filePath = Uri.parse("file://${image.absolutePath}")
        return image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                PICK_IMAGE_REQUEST -> pickImage(data)
                REQUEST_TAKE_PHOTO -> viewPhotoOnScreen()
                else -> Log.e(CLASS_TAG, "RESULT_ERROR")
            }
        }
    }

    private fun pickImage(data: Intent?) {
        if(data != null && data.data != null) {
            filePath = data.data
            viewPhotoOnScreen()
        }
    }

    private fun viewPhotoOnScreen() {
        Picasso.get().load(filePath).into(imgView)
    }

    protected fun startActivityChooseImage(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }
}