package com.example.alfagallery

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import com.example.alfagallery.presenter.BasePhotoPresenter

class MyAdapter(val presenter: BasePhotoPresenter) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return MyViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return presenter.getItemCount()
    }

    @StateStrategyType(value = SingleStateStrategy::class)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        presenter.bindView(holder)
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }

    class MyViewHolder(itemView: View, var presenter: BasePhotoPresenter)
        : RecyclerView.ViewHolder(itemView), IViewHolder, View.OnClickListener {
        private val CLASS_TAG = "MyViewHolder"

        private var image: ImageView = itemView.findViewById(R.id.image)

        init {
            itemView.setOnClickListener(this)
        }

        override fun setImageOne(source: Uri?) {
            Picasso.get().load(source).resize(340, 340).into(image)
        }

        override fun getPos() = position

        override fun onClick(v: View?) {
            println(getPos())
            presenter.clicked(getPos())
        }
    }
}