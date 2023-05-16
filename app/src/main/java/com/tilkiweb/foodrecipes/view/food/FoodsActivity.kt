package com.tilkiweb.foodrecipes.view.food

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tilkiweb.foodrecipes.R
import com.tilkiweb.foodrecipes.view.Sub.SubCategoryAdapter
import com.tilkiweb.foodrecipes.view.detail.DetailViewModel
import kotlinx.coroutines.launch

class FoodsActivity : AppCompatActivity() {
    lateinit var viewModel :FoodViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)
        viewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        lifecycleScope.launch {
            val id = intent.getStringExtra("id")
            viewModel.getfoods(id)
        }

        val returnView = findViewById<ImageView>(R.id.toolbarReturnTv)

        returnView.setOnClickListener {
            onBackPressed()
        }

        val definition = intent.getStringExtra("definition")


        val textviewtoolbar = findViewById<TextView>(R.id.CategoryToolbarTv)

        textviewtoolbar.text = definition

        viewModel.foods.observe(this, Observer {
            val recyclerview = findViewById<RecyclerView>(R.id.food_rv)

            recyclerview.layoutManager = LinearLayoutManager(this)

            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerview.layoutManager = layoutManager


            val adapter = FoodAdapter(it!!)
            recyclerview.adapter = adapter

        })
    }
}