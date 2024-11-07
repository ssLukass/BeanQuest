package com.example.beanquest.Adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beanquest.Models.PopularDish
import com.example.beanquest.databinding.HomeFoodItemBinding
import kotlinx.coroutines.CoroutineStart

class PopularAdapter(
    val context: Context,
    private val list : List<PopularDish>
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        val binding = HomeFoodItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {

        val listModel = list[position]
        val decodedBytes = Base64.decode(listModel.foodImage, Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)

        holder.foodImage.setImageBitmap(bitmap)
        holder.foodName.text = listModel.foodName
        holder.foodPrice.text = "${listModel.foodPrice} тг"
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class PopularViewHolder(binding : HomeFoodItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val foodImage = binding.homeFoodImage
        val foodName = binding.homeFoodName
        val foodPrice = binding.homeFoodPrice
    }

}