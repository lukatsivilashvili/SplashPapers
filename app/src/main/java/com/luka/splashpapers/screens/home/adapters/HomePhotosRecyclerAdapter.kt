package com.luka.splashpapers.screens.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.luka.splashpapers.databinding.PhotosLayoutBinding
import com.luka.splashpapers.screens.home.models.HomePaginatedModelItem
import com.luka.splashpapers.utils.HomePhotosComparator
import com.luka.splashpapers.utils.OnItemClickListener
import com.luka.splashpapers.utils.loadImage


class HomePhotosRecyclerAdapter(
    private val itemClickListener: OnItemClickListener
) :
    PagingDataAdapter<HomePaginatedModelItem, HomePhotosRecyclerAdapter.MyViewHolder>(
        HomePhotosComparator
    ) {

    inner class MyViewHolder(private val binding: PhotosLayoutBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        fun bind() {

            val photo = getItem(absoluteAdapterPosition)
            binding.ivHome.loadImage(photo?.urls?.regular!!, photo.color!!)
            binding.root.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            itemClickListener.clickItem(
                bindingAdapterPosition,
                getItem(absoluteAdapterPosition)?.id.toString()
            )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            PhotosLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }
}