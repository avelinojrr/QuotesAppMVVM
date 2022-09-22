package com.example.quotesappmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.quotesappmvvm.databinding.ActivityMainBinding
import com.example.quotesappmvvm.viewmodel.TitleViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: TitleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // vamos a enlazar el layout con el view usando el observer y el viewmodel
        // con binding

        quoteViewModel.titleModel.observe(this, Observer {
            binding.TextContainerView.text = it.title
            binding.creditsContainerView.text = it.credits
        })

        binding.containerView.setOnClickListener { quoteViewModel.getTitle()}

    }
}