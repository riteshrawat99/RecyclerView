package com.pupup.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),MyAdapter.OnItemClickListener {
    lateinit var listItem : ArrayList<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView : RecyclerView = findViewById(R.id.recycleView)
        recycleView.layoutManager = LinearLayoutManager(this)


         listItem = arrayListOf(
            Model("Itme1","Description1"),
            Model("Itme2","Description2"),
            Model("Itme3","Description3"),
            Model("Itme4","Description4"),
            Model("Itme5","Description5"),
            Model("Itme6","Description6"),
            Model("Itme7","Description7"),
            Model("Itme8","Description8"),
            Model("Itme9","Description9"),
            Model("Itme10","Description10"),
            Model("Itme11","Description11")

        )
        val adapter = MyAdapter(listItem,this)
        recycleView.adapter = adapter
    }

    override fun onItemClick(position: Int) {
//        Toast.makeText(this@MainActivity, "Item Clicked at Position $position", Toast.LENGTH_SHORT).show()
        Toast.makeText(this@MainActivity, listItem[position].title.toString() , Toast.LENGTH_SHORT).show()
    }
}