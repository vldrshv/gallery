package com.example.alfagallery;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/alfagallery/IViewHolder;", "", "getPos", "", "onClick", "", "v", "Landroid/view/View;", "setImageOne", "source", "Landroid/net/Uri;", "app_debug"})
public abstract interface IViewHolder {
    
    public abstract void setImageOne(@org.jetbrains.annotations.Nullable()
    android.net.Uri source);
    
    public abstract int getPos();
    
    public abstract void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v);
}