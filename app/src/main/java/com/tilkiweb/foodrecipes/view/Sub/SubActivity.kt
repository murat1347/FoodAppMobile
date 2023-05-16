package com.tilkiweb.foodrecipes.view.Sub

import android.annotation.SuppressLint
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
import kotlinx.coroutines.launch

class SubActivity : AppCompatActivity() {
    lateinit var viewModel: SubViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        viewModel = ViewModelProvider(this).get(SubViewModel::class.java)

        val definition = intent.getStringExtra("definition")

        lifecycleScope.launch {
            val id = intent.getStringExtra("id")
            viewModel.getcategories(id)
        }

        val subcategortoolbartv = findViewById<TextView>(R.id.subCategoryToolbarTv)
        val subcategoryreturn = findViewById<ImageView>(R.id.subtoolbarReturnTv)

        subcategortoolbartv.text= definition
        subcategoryreturn.setOnClickListener {
            onBackPressed()
        }

        viewModel.categories.observe(this, Observer {
            val recyclerview = findViewById<RecyclerView>(R.id.foodsRv)

            recyclerview.layoutManager = LinearLayoutManager(this)

            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerview.layoutManager = layoutManager


            val adapter = SubCategoryAdapter(it!!)
            recyclerview.adapter = adapter

        })
    }


}
