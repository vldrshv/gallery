package com.example.alfagallery

import android.app.Activity
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import android.content.Intent
import android.provider.MediaStore
import java.io.IOException
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.FirebaseStorage
import android.widget.Toast
import java.util.*
import android.util.Log


class MainActivity : AppCompatActivity() {
    private val CLASS_TAG = "MainActivity"

    private lateinit var btnChoose: Button
    private lateinit var btnUpload: Button
    private lateinit var imageView: ImageView

    //Firebase
    private lateinit var storage: FirebaseStorage
    private lateinit var storageReference: StorageReference

    private var filePath: Uri? = null
    private var path = ""

    private val PICK_IMAGE_REQUEST = 71

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        initStorage()
    }

    private fun initUI() {
        btnChoose = findViewById(R.id.btnChoose)
        btnUpload = findViewById(R.id.btnUpload)
        imageView = findViewById(R.id.imgView)

        btnChoose.setOnClickListener { chooseImage() }
        btnUpload.setOnClickListener { uploadImage() }
        imageView.setOnClickListener { openImage() }
    }
    private fun initStorage() {
        storage = FirebaseStorage.getInstance()
        storageReference = storage.reference
    }

    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
            && data != null && data.data != null
        ) {
            Log.i(CLASS_TAG, data.toString())
            filePath = data.data
            path = data.toUri(Intent.URI_INTENT_SCHEME)
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imageView.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
    }
    private fun uploadImage() {

        if (filePath != null) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            val ref = storageReference.child("images/" + UUID.randomUUID().toString())
            ref.putFile(filePath!!)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(this@MainActivity, "Uploaded", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@MainActivity, "Failed " + e.message, Toast.LENGTH_SHORT)
                        .show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot
                        .totalByteCount
                    progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
                }
        }
    }
    private fun openImage() {
        if (path != "") {
//            Log.i(CLASS_TAG, filePath.toString() + " " + path)
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.setDataAndType(filePath, "image/*")
            startActivity(intent)
        }
    }
}
