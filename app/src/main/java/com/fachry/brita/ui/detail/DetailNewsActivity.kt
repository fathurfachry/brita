package com.fachry.brita.ui.detail

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.fachry.brita.data.model.ArticlesItem
import com.fachry.brita.databinding.ActivityDetailNewsBinding
import com.squareup.picasso.Picasso

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    companion object {
        const val DATA_NEWS = "data_news"
        const val DATE_NEWS = "date_news"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataNews = intent.getParcelableExtra<ArticlesItem>(DATA_NEWS)
        val date = intent.getStringExtra(DATE_NEWS)

//        Log.d("DetailActivity", "title : ${data?.title} ")

        setupMyXml(dataNews, date)
        setupWebView(dataNews)
    }

    private fun setupWebView(dataNews: ArticlesItem?) {
        val webSetting = binding.wvDetail.settings
        webSetting.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        binding.wvDetail.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.loadingView.root.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.loadingView.root.visibility = View.GONE
            }
        }

        dataNews?.link?.let {
            binding.wvDetail.loadUrl(it)
        }
    }

    private fun setupMyXml(dataNews: ArticlesItem?, date: String?) {
        binding.apply {
            detailTitle.text = dataNews?.title
            detailPublishedAt.text = date

            Picasso.get()
                .load(dataNews?.thumbnail)
                .fit()
                .centerInside()
                .into(detailImage)
        }
    }


}