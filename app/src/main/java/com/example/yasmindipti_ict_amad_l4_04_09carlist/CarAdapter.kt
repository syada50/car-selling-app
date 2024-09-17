package com.example.yasmindipti_ict_amad_l4_04_09carlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.yasmindipti_ict_amad_l4_04_09carlist.databinding.CarItemBinding


class CarAdapter (private val carList:ArrayList<Car>):RecyclerView.Adapter<CarAdapter.MyviewHolder>() {

    var onClick : ((Car)->Unit)?=null
    class MyviewHolder (val binding: CarItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view = CarItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.binding.apply {
            carName.text= carList[position].carName
            carmodel.text= "Model: "+carList[position].carmodel.toString()
            carPrice.text="Price: "+carList[position].carPrice.toString()
            carImg.setImageResource(carList[position].carImg)

        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(carList[position])
    }
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Fruit Item")
                .setMessage("Are you sure you want to delete this item?")
                .setPositiveButton("Yes") { _, _ ->
                    carList.removeAt(position)
                    notifyItemRemoved(position)
}
                .setNegativeButton("No", null)
                .show()
            true
        }


    }


}


