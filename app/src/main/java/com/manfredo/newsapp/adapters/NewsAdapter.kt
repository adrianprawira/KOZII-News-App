package com.manfredo.newsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manfredo.newsapp.R
import com.manfredo.newsapp.models.Docs
import com.manfredo.newsapp.util.Constants.Companion.BASE_IMG_URL
import kotlinx.android.synthetic.main.item_article.view.*
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Docs>() {
        override fun areItemsTheSame(oldItem: Docs, newItem: Docs): Boolean {
            return oldItem.web_url == newItem.web_url
        }

        override fun areContentsTheSame(oldItem: Docs, newItem: Docs): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleDocs = differ.currentList[position]

        val dateTimeZoneFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
        val newFormatDateTime = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
        val dateTime = dateTimeZoneFormatter.parseObject(articleDocs.pub_date)
        val newDateTime = newFormatDateTime.format(dateTime)

        holder.itemView.apply {
            Glide.with(this).load(BASE_IMG_URL + articleDocs.multimedia?.getOrNull(position)?.url).into(ivArticleImage)
            tvTitle.text = articleDocs.headline?.main
            tvDescription.text = articleDocs.snippet
            tvPublishedAt.text = newDateTime.toString()
            tvSource.text = articleDocs.source
            setOnClickListener {
                onItemClickListener?.let {
                    it(articleDocs)
                }
            }
        }
    }

    private var onItemClickListener: ((Docs) -> Unit)? = null

    fun setOnItemClickListener(listener: (Docs) -> Unit) {
        onItemClickListener = listener
    }

}