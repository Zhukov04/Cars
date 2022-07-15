package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var adapter = CarAdapter()
    private val imageIdList = listOf(
        R.drawable.car1,
        R.drawable.car2,
        R.drawable.car3,
        R.drawable.car4,
        R.drawable.car5,
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if(index>4) index = 0
                val car = Car(imageIdList[index],"Car $index")
                adapter.addCars(car)
                index++
            }
        }
    }
}