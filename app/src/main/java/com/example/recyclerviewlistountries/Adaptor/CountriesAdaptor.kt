package com.example.recyclerviewlistountries.Adaptor


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewlistountries.Model.CountriesModel
import com.example.recyclerviewlistountries.R
import com.example.recyclerviewlistountries.databinding.CntryItemBinding


class CountriesAdaptor : RecyclerView.Adapter<CountriesAdaptor.CntryViewHolder>() {

    private var cntryList = emptyList<CountriesModel>()

    class CntryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CntryItemBinding.bind(view)
        fun bind(countriesModel: CountriesModel)= with(binding){
            imgFlag.setImageResource(countriesModel.cntryFlag)
            nameCntry.text = countriesModel.cntryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CntryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cntry_item, parent, false)
        return CntryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cntryList.size
    }

    override fun onBindViewHolder(holder: CntryViewHolder, position: Int) {
        holder.bind(cntryList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCntry(list: List<CountriesModel>){
        cntryList = list
        notifyDataSetChanged()
    }


}