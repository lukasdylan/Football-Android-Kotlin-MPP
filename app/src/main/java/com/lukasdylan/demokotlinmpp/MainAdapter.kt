package com.lukasdylan.demokotlinmpp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_favorite.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.TestViewHolder>() {

    private var dataList: List<String> = emptyList()

    fun submit(data: List<String>) {
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return TestViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    class TestViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(text: String) {
            itemView.tv_show_name?.text = text
        }
    }
}