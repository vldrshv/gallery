package com.example.alfagallery.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/example/alfagallery/presenter/ServerPresenter;", "", "view", "Lcom/example/alfagallery/IPhotoChoose;", "(Lcom/example/alfagallery/IPhotoChoose;)V", "CLASS_TAG", "", "firebase", "Lcom/example/alfagallery/model/Firebase;", "getView", "()Lcom/example/alfagallery/IPhotoChoose;", "uploadImageToServer", "", "progressDialog", "Landroid/app/ProgressDialog;", "filePath", "Landroid/net/Uri;", "app_debug"})
public final class ServerPresenter {
    private final java.lang.String CLASS_TAG = "Presenter";
    private final com.example.alfagallery.model.Firebase firebase = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.alfagallery.IPhotoChoose view = null;
    
    public final void uploadImageToServer(@org.jetbrains.annotations.NotNull()
    android.app.ProgressDialog progressDialog, @org.jetbrains.annotations.NotNull()
    android.net.Uri filePath) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.alfagallery.IPhotoChoose getView() {
        return null;
    }
    
    public ServerPresenter(@org.jetbrains.annotations.Nullable()
    com.example.alfagallery.IPhotoChoose view) {
        super();
    }
    
    public ServerPresenter() {
        super();
    }
}