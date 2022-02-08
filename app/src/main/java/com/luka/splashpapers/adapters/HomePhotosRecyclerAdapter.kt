package com.luka.splashpapers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luka.splashpapers.databinding.PhotosLayoutBinding
import com.luka.splashpapers.screens.home.models.HomeModelFace
import com.luka.splashpapers.utils.loadImage

class HomePhotosRecyclerAdapter() :
    RecyclerView.Adapter<HomePhotosRecyclerAdapter.ItemViewHolder>() {
    val photos = mutableListOf<HomeModelFace>()


    inner class ItemViewHolder(private val binding: PhotosLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: HomeModelFace

        fun bind(){
            model = photos[absoluteAdapterPosition]
            binding.ivHome.loadImage(model.urls?.regular!!, model.colors.toString())
            binding.tvLikes.text = model.likes.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            PhotosLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = photos.size


    fun setData(country: MutableList<HomeModelFace>) {
        this.photos.addAll(country)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.photos.clear()
        notifyDataSetChanged()
    }
}
