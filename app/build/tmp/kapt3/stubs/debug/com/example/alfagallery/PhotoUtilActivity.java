package com.example.alfagallery;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0004J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0004J\b\u0010\u001f\u001a\u00020\u0017H\u0004J\b\u0010 \u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/example/alfagallery/PhotoUtilActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CLASS_TAG", "", "PICK_IMAGE_REQUEST", "", "REQUEST_TAKE_PHOTO", "filePath", "Landroid/net/Uri;", "getFilePath", "()Landroid/net/Uri;", "setFilePath", "(Landroid/net/Uri;)V", "presenter", "Lcom/example/alfagallery/presenter/ServerPresenter;", "getPresenter", "()Lcom/example/alfagallery/presenter/ServerPresenter;", "setPresenter", "(Lcom/example/alfagallery/presenter/ServerPresenter;)V", "createImageFile", "Ljava/io/File;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "openCameraIntent", "pickImage", "startActivityChooseImage", "uploadImageToServer", "viewPhotoOnScreen", "app_debug"})
public class PhotoUtilActivity extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String CLASS_TAG = "PhotoUtilActivity";
    private final int REQUEST_TAKE_PHOTO = 71;
    private final int PICK_IMAGE_REQUEST = 1;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri filePath;
    @org.jetbrains.annotations.NotNull()
    protected com.example.alfagallery.presenter.ServerPresenter presenter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final android.net.Uri getFilePath() {
        return null;
    }
    
    protected final void setFilePath(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.example.alfagallery.presenter.ServerPresenter getPresenter() {
        return null;
    }
    
    protected final void setPresenter(@org.jetbrains.annotations.NotNull()
    com.example.alfagallery.presenter.ServerPresenter p0) {
    }
    
    protected final void openCameraIntent() {
    }
    
    protected final void uploadImageToServer() {
    }
    
    private final java.io.File createImageFile() throws java.io.IOException {
        return null;
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void pickImage(android.content.Intent data) {
    }
    
    private final void viewPhotoOnScreen() {
    }
    
    protected final void startActivityChooseImage() {
    }
    
    public PhotoUtilActivity() {
        super();
    }
}