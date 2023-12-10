package com.fachry.brita.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fachry.brita.R
import com.fachry.brita.data.model.ArticlesItem
import com.fachry.brita.databinding.ItemRowNewsBinding
import com.fachry.brita.ui.detail.DetailNewsActivity
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Locale

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val listNews = ArrayList<ArticlesItem>()

    fun setData(list: List<ArticlesItem>?){
        listNews.clear()
        if (list != null){
            listNews.addAll(list)
        }
        notifyItemRangeChanged(0, listNews.size)
    }

    class ViewHolder(val binding: ItemRowNewsBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataNews = listNews[position]

        val dateTimeString = dataNews.pubDate
        val dateTimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val date = dateTimeFormat.parse(dateTimeString)
        val myDateFormat = SimpleDateFormat("EEE, dd MMMM | HH:mm", Locale.getDefault())

        val myDate = myDateFormat.format(date)

        holder.binding.apply {
            tvTitle.text = dataNews.title
            tvDate.text = myDate

            Picasso.get()
                .load(dataNews.thumbnail)
                .fit()
                .centerInside()
                .placeholder(R.drawable.ic_news)
                .into(imgNews)
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailNewsActivity::class.java)
            intent.putExtra(DetailNewsActivity.DATA_NEWS, dataNews)
            intent.putExtra(DetailNewsActivity.DATE_NEWS, myDate)
            holder.itemView.context.startActivity(intent)
        }
    }
}