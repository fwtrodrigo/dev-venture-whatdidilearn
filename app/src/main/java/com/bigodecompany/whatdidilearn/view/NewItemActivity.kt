package com.bigodecompany.whatdidilearn.view

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.bigodecompany.whatdidilearn.databinding.ActivityNewItemBinding
import com.bigodecompany.whatdidilearn.entities.LearnedItem
import com.bigodecompany.whatdidilearn.entities.UnderstandingLevel
import com.bigodecompany.whatdidilearn.viewmodel.NewItemViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewItemBinding
    private val viewModel: NewItemViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btSave = binding.btSave
        btSave.setOnClickListener {
            onSaveClickListener()
            onBackPressed()
        }

//        viewModel.showError.observe(this, Observer {
//            if (it == true) {
//                Toast.makeText(this, "Favor, preencher todos os campos", Toast.LENGTH_LONG).show()
//            }
//        })
    }

    private fun onSaveClickListener() {
        val title = binding.etItemTitle.text.toString()
        val description = binding.etmItemDescription.text.toString()

        val radioButtonTag =
            findViewById<RadioButton>(binding.rdgLevels.checkedRadioButtonId).tag.toString()

        val level =
            UnderstandingLevel.valueOf(radioButtonTag.uppercase())

        val newItem =
            LearnedItem(name = title, description = description, understandingLevel = level)
        viewModel.insertForm(newItem)
    }
}