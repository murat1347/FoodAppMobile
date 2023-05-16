package com.tilkiweb.foodrecipes.view.food

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilkiweb.foodrecipes.databinding.FoodCardDesingBinding
import com.tilkiweb.foodrecipes.models.res.FoodsResponse
import com.tilkiweb.foodrecipes.models.res.SubCategoryResponse
import com.tilkiweb.foodrecipes.view.detail.ActivityDetail

class FoodAdapter(val CardList: FoodsResponse) : RecyclerView.Adapter<FoodAdapter.CardHolder>() {
    class CardHolder(val binding : FoodCardDesingBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = FoodCardDesingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.binding.textViewFoodName.text= CardList?.foods?.get(position)?.title
        Glide.with(holder.itemView.context)
            .load(CardList?.foods?.get(position)?.foodImageFiles?.images?.get(0)?.imageUrl)
            .into(holder.binding.imageViewFoodImage)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("definition", CardList?.foods?.get(position)?.description)
            bundle.putString("imageUrl", CardList?.foods?.get(position)?.foodImageFiles?.images?.get(0)?.imageUrl)
            bundle.putString("id",CardList?.foods?.get(position)?.id)
            // Intent nesnesine verileri ekleyin ve ActivityDetail sınıfına yönlendirin
            val intent = Intent(holder.itemView.context, ActivityDetail::class.java)
            intent.putExtras(bundle)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return CardList.foods.size
    }

}