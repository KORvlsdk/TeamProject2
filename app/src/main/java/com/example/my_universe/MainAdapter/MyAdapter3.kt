package com.example.my_universe.MainAdapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_universe.ApiModel.ItemModel77
import com.example.my_universe.databinding.ItemImageBinding
import com.example.my_universe.model.BoardItemDto

class MyViewHolder3(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter3(val context: Context, val datas: MutableList<BoardItemDto>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {




    fun setData(newItems: List<BoardItemDto>) {
        datas.clear()
        datas.addAll(newItems)
        notifyDataSetChanged()
    }
    fun addData(newItems: List<BoardItemDto>) {
        datas.addAll(newItems)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder3(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    override fun getItemCount(): Int {
        Log.d("lsy", "getItemCount : ${datas.size}")
        return datas.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("lsy", "onBindViewHolder : $position")
        val binding = (holder as MyViewHolder3).binding

        binding.testText.text = datas[position].title
        binding.descriptionText.text = datas[position].subTitle





        var imgList: MutableList<String> = mutableListOf<String>()
        imgList = datas[position].images.toMutableList()
        binding.tapFragSliderviewPager1.adapter = MyAdapter2(context, imgList)
    }
}
