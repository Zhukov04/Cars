package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CarsItemBinding


class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {
    val carlist = ArrayList<Car>()

    class CarHolder(item: View) : RecyclerView.ViewHolder(item) {
        var binding = CarsItemBinding.bind(item)
        fun bind(car: Car) = with(binding) {
            im.setImageResource(car.imagedId)
            tvTitle.text = car.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cars_item, parent, false)
        return CarHolder(view)
    }

    override fun getItemCount(): Int {
        return carlist.size

    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(carlist[position])

    }

    fun addCars(car: Car) {
        carlist.add(car)
        notifyDataSetChanged()
    }


}

