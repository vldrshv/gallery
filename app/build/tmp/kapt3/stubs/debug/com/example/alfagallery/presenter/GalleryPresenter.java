package com.example.alfagallery.presenter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0006\u0010\u0019\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/example/alfagallery/presenter/GalleryPresenter;", "Lcom/example/alfagallery/presenter/BasePhotoPresenter;", "view", "Lcom/example/alfagallery/IGalleryView;", "(Lcom/example/alfagallery/IGalleryView;)V", "CLASS_TAG", "", "firebase", "Lcom/example/alfagallery/model/Firebase;", "photoList", "Ljava/util/ArrayList;", "Lcom/example/alfagallery/model/Photo;", "Lkotlin/collections/ArrayList;", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "getView", "()Lcom/example/alfagallery/IGalleryView;", "bindView", "", "iViewHolder", "Lcom/example/alfagallery/view/recycler/IViewHolder;", "clicked", "pos", "", "getItemCount", "getPhotos", "app_debug"})
public final class GalleryPresenter implements com.example.alfagallery.presenter.BasePhotoPresenter {
    private final java.lang.String CLASS_TAG = "RecyclerViewPresenter";
    private java.util.ArrayList<com.example.alfagallery.model.Photo> photoList;
    private com.example.alfagallery.model.Firebase firebase;
    private com.google.firebase.storage.StorageReference storageReference;
    @org.jetbrains.annotations.NotNull()
    private final com.example.alfagallery.IGalleryView view = null;
    
    public final void getPhotos() {
    }
    
    @java.lang.Override()
    public void bindView(@org.jetbrains.annotations.NotNull()
    com.example.alfagallery.view.recycler.IViewHolder iViewHolder) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void clicked(int pos) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.alfagallery.IGalleryView getView() {
        return null;
    }
    
    public GalleryPresenter(@org.jetbrains.annotations.NotNull()
    com.example.alfagallery.IGalleryView view) {
        super();
    }
}