package com.tilkiweb.foodrecipes.view.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilkiweb.foodrecipes.databinding.FoodCardDesingBinding
import com.tilkiweb.foodrecipes.models.res.CategoryResponse
import com.tilkiweb.foodrecipes.view.Sub.SubActivity

class CategoryRvAdapter(val CardList: CategoryResponse) : RecyclerView.Adapter<CategoryRvAdapter.CardHolder>() {
    class CardHolder(val binding : FoodCardDesingBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = FoodCardDesingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.binding.textViewFoodName.text= CardList?.category?.get(position)?.defination
        Glide.with(holder.itemView.context)
            .load(CardList?.category?.get(position)?.imageUrl)
            .into(holder.binding.imageViewFoodImage)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("definition", CardList?.category?.get(position)?.defination)
            bundle.putString("imageUrl", CardList?.category?.get(position)?.imageUrl)
            bundle.putString("id",CardList?.category?.get(position)?.id)
            // Intent nesnesine verileri ekleyin ve ActivityDetail sınıfına yönlendirin
            val intent = Intent(holder.itemView.context, SubActivity::class.java)
            intent.putExtras(bundle)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return CardList.category.size
    }

}