package com.example.vehicleinfo1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.vehicleinfo1.R
import com.example.vehicleinfo1.databinding.ActivityMainBinding
import com.example.vehicleinfo1.model.Counter
import com.example.vehicleinfo1.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding1: ActivityMainBinding

    private lateinit var viewmodel1: CounterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        //Initialize ViewModel
        //viewmodel1 = ViewModelProvider(this).get(CounterViewModel::class.java)
        viewmodel1 = ViewModelProvider(this)[CounterViewModel::class.java]

        viewmodel1.counter.observe(this) { x ->
            binding1.counterText1.text = x.count.toString()
        }
        binding1.plusBtn1.setOnClickListener{
            viewmodel1.incrementCounter()

        }
        binding1.minusBtn1.setOnClickListener {
            viewmodel1.decrementCounter()

        }



    }
}