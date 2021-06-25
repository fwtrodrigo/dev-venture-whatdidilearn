package com.bigodecompany.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bigodecompany.whatdidilearn.databinding.ActivityMainBinding
import com.bigodecompany.whatdidilearn.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.learnedItemsRecyclerView
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter


        val items = viewModel.leardItems

        items.observe(this, Observer {
            adapter.learnedItems = it
        })

        binding.newItemButton.setOnClickListener {
            val intent = Intent(this, NewItemActivity::class.java)
            startActivity(intent)
        }
    }
}