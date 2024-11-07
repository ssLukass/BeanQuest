package com.example.beanquest.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beanquest.Models.PopularModel
import com.example.beanquest.databinding.HomeFoodItemBinding

class PopularAdapter(
    val context: Context,
    val list : ArrayList<PopularModel>
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        val binding = HomeFoodItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {

        val listModel =list[position]
        listModel.getFoodImage()?.let { holder.foodImage.setImageResource(it) }
        holder.foodName.text = listModel.getFoodName()
        holder.foodPrice.text = listModel.getFoodPrice()


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