package com.example.baitap1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.baitap1.databbinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// Quan sát dữ liệu từ LiveData trong ViewModel
        viewModel.counter.observe(this, Observer { count ->
            binding.tvCounter.text = count.toString()
        })

        // Tăng giá trị khi người dùng nhấn nút
        binding.btnIncrement.setOnClickListener {
            viewModel.incrementCounter()
        }
    }
}