package com.example.yasmindipti_ict_amad_l4_04_09carlist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yasmindipti_ict_amad_l4_04_09carlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var carAdapter: CarAdapter
    val car= ArrayList<Car>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.carRv.layoutManager = LinearLayoutManager(this)
        
        car.add(Car("Black car",23456,500.0, R.drawable.black,"almost new"))
        car.add(Car("Blue car",23457,500.0, R.drawable.blue,"almost new"))
        car.add(Car("GLOSSYBLACK car",23458,500.0, R.drawable.glossyblack,"almost new"))
        car.add(Car("GRAY car",23459,500.0, R.drawable.gray,"almost new"))
        car.add(Car("INDIGO car",23460,500.0, R.drawable.indigo,"almost new"))
        car.add(Car("ORANGE car",23461,500.0, R.drawable.orange,"almost new"))
        car.add(Car("PASTE car",23462,500.0, R.drawable.paste,"almost new"))
        car.add(Car("RED car",23463,500.0, R.drawable.red,"almost new"))
        car.add(Car("REDJEEP car",23464,500.0, R.drawable.jeep,"almost new"))
        car.add(Car("WHITE car",23465,500.0, R.drawable.white,"almost new"))
        car.add(Car("YELLOW car",23466,500.0, R.drawable.yellow,"almost new"))
        car.add(Car("A",23467,500.0, R.drawable.a,"almost new"))
        car.add(Car("B",23468,500.0, R.drawable.b,"almost new"))
        car.add(Car("B",23469,500.0, R.drawable.c,"almost new"))
        car.add(Car("B",23470,500.0, R.drawable.d,"almost new"))
        car.add(Car("Black car",23456,500.0, R.drawable.black,"almost new"))
        car.add(Car("Blue car",23457,500.0, R.drawable.blue,"almost new"))
        car.add(Car("GLOSSYBLACK car",23458,500.0, R.drawable.glossyblack,"almost new"))
        car.add(Car(".GRAY car",23459,500.0, R.drawable.gray,"almost new"))
        car.add(Car("INDIGO car",23460,500.0, R.drawable.indigo,"almost new"))
        car.add(Car("ORANGE car",23461,500.0, R.drawable.orange,"almost new"))
        car.add(Car("PASTE car",23462,500.0, R.drawable.paste,"almost new"))
        car.add(Car("RED car",23463,500.0, R.drawable.red,"almost new"))
        car.add(Car("REDJEEP",23464,500.0, R.drawable.jeep,"almost new"))
        car.add(Car("WHITE car",23465,500.0, R.drawable.white,"almost new"))
        car.add(Car("YELLOW car",23466,500.0, R.drawable.yellow,"almost new"))
        car.add(Car("A",23467,500.0, R.drawable.a,"almost new"))
        car.add(Car("B",23468,500.0, R.drawable.b,"almost new"))
        car.add(Car("B",23469,500.0, R.drawable.c,"almost new"))
        car.add(Car("B",23470,500.0, R.drawable.d,"almost new"))


      carAdapter =CarAdapter(car)
        binding.carRv.adapter= carAdapter

        carAdapter.onClick={
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", it.carName)
            intent.putExtra("price", it.carPrice)
            intent.putExtra("quantity", it.carmodel)
            intent.putExtra("desc", it.carDesc)
            intent.putExtra("image", it.carImg)
            startActivity(intent)
        }
        binding.addBtn.setOnClickListener {
            showcarAddDialog()
        }
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                car.removeAt(viewHolder.adapterPosition)
                carAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.carRv)

            }
    private fun showcarAddDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.add_car_layout, null)
        val nameEt = dialogView.findViewById<EditText>(R.id.carNameEt)
        val priceEt = dialogView.findViewById<EditText>(R.id.carPriceEt)
        val modelEt = dialogView.findViewById<EditText>(R.id.carmodelEt)
        val descEt = dialogView.findViewById<EditText>(R.id.carDescEt)

        AlertDialog.Builder(this)
            .setTitle("Add car")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val name = nameEt.text.toString()
                val price = priceEt.text.toString().toDouble()
                val model = modelEt.text.toString().toInt()
                val desc = descEt.text.toString()
                val img = R.drawable.red

                car.add(Car(name, model, price, img, desc))
                carAdapter.notifyItemInserted(car.size - 1)
            }
            .setNegativeButton("Cancel", null)
            .show()

    }


}