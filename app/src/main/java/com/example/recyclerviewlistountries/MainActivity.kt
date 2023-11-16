package com.example.recyclerviewlistountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlistountries.Adaptor.CountriesAdaptor
import com.example.recyclerviewlistountries.Model.CountriesModel
import com.example.recyclerviewlistountries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptor: CountriesAdaptor
    private lateinit var recyclerView: RecyclerView
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.rcView.layoutManager = GridLayoutManager(this@MainActivity, 1)
        recyclerView = binding.rcView
        adaptor = CountriesAdaptor()
        recyclerView.adapter = adaptor
        adaptor.addCntry(addItems())
    }

    fun addItems(): ArrayList<CountriesModel> {
        val cntryList = ArrayList<CountriesModel>()
        for (i in 0 until CntryRes.imgList.size) {
            val cntry = CountriesModel(CntryRes.imgList[i], CntryRes.nameList[i])
            cntryList.add(cntry)

        }


//        val cntry = CountriesModel(CntryRes.imgList[0], CntryRes.nameList[0])
//        cntryList.add(cntry)
//        val cntry2 = CountriesModel(CntryRes.imgList[1], CntryRes.nameList[1])
//        cntryList.add(cntry2)
        return cntryList

    }
}