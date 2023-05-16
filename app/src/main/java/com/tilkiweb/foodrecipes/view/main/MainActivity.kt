package com.tilkiweb.foodrecipes.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tilkiweb.foodrecipes.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycleScope.launch {
            viewModel.getCategories()
        }
        viewModel.categories.observe(this, Observer {
            val recyclerview = findViewById<RecyclerView>(R.id.kategoriRv)

            val spanCount = 2 // Sütun sayısını belirleyin
            val spacing = 16 // Dış boşlukları belirleyin (pixel cinsinden)
            val includeEdge = true

            recyclerview.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))
            recyclerview.layoutManager = GridLayoutManager(this, spanCount, VERTICAL,false)


            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
           // recyclerview.layoutManager = layoutManager


            val adapter = CategoryRvAdapter(it)
            recyclerview.adapter = adapter

        })
    }
}