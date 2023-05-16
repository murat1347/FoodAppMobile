package com.tilkiweb.foodrecipes.view.detail

import android.annotation.SuppressLint
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilkiweb.foodrecipes.R
import com.tilkiweb.foodrecipes.view.food.FoodAdapter
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class ActivityDetail : AppCompatActivity() {
    private lateinit var viewModel: DetailViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)


        val foodnametv = findViewById<TextView>(R.id.foodNameTv)

        val imagereturn = findViewById<ImageView>(R.id.imageView2)

        imagereturn.setOnClickListener {
            onBackPressed()
        }
        lifecycleScope.launch {
            val id = intent.getStringExtra("id")
            viewModel.getfood(id)
        }
        viewModel.categories.observe(this, Observer {


            val textViewFoodName =  findViewById<TextView>(R.id.textViewFoodName)
            val imageView = findViewById<ImageView>(R.id.imageView)
            val textViewYil = findViewById<TextView>(R.id.textViewYil)
            Glide.with(this)
                .load(it?.foodImageFiles?.images?.get(0)?.imageUrl)
                .into(imageView)
            //textViewFoodName.text=it?.title
            textViewYil.setText(it?.description)
            foodnametv.text=it?.title
        })
    }
}