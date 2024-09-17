package com.example.yasmindipti_ict_amad_l4_04_09carlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yasmindipti_ict_amad_l4_04_09carlist.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val price = intent.getDoubleExtra("price", 0.0)
        val model = intent.getIntExtra("model", 0)
        val img = intent.getIntExtra("image", 0)
        val desc = intent.getStringExtra("desc")
        binding.apply {
            carName.text = name
            carPrice.text = "price: $" + price.toString()
            carmodel.text = "Model: " + model.toString()
            carImg.setImageResource(img)
            carDesc.text = desc
        }
    }
}