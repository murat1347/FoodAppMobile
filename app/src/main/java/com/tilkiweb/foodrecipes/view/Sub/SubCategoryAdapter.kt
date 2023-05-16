package com.tilkiweb.foodrecipes.view.Sub

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilkiweb.foodrecipes.databinding.FoodCardDesingBinding
import com.tilkiweb.foodrecipes.models.res.SubCategoryResponse
import com.tilkiweb.foodrecipes.view.food.FoodsActivity

class SubCategoryAdapter(val CardList: SubCategoryResponse) : RecyclerView.Adapter<SubCategoryAdapter.CardHolder>() {
    class CardHolder(val binding : FoodCardDesingBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = FoodCardDesingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.binding.textViewFoodName.text= CardList?.categories?.get(position)?.defination
        Glide.with(holder.itemView.context)
            .load(CardList?.categories?.get(position)?.imageUrl)
            .into(holder.binding.imageViewFoodImage)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("definition", CardList?.categories?.get(position)?.defination)
            bundle.putString("imageUrl", CardList?.categories?.get(position)?.imageUrl)
            bundle.putString("id",CardList?.categories?.get(position)?.id)
            // Intent nesnesine verileri ekleyin ve ActivityDetail sınıfına yönlendirin
            val intent = Intent(holder.itemView.context, FoodsActivity::class.java)
            intent.putExtras(bundle)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return CardList.categories.size
    }

}