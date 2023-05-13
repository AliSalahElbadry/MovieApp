package com.example.movieapp.movie_show.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movieapp.R
import com.example.movieapp.model.Item
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


class MovieShowAdapter: RecyclerView.Adapter<MovieShowAdapter.MovieCellHolder>() {
    lateinit var movieList:List<Item>
    var context:Context?=null
    class MovieCellHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
       var image:ImageView=itemView.findViewById(R.id.imageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCellHolder {
        context=parent.context
       return  MovieCellHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }
    override fun getItemCount(): Int {
        return  movieList.size
    }

    override fun onBindViewHolder(holder: MovieCellHolder, position: Int) {
        Picasso.with(holder.itemView.context)
            .load(movieList[position].image)
            .resize(1200,1400)
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(holder.image)

    }
}