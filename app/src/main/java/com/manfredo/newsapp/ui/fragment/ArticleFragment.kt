package com.manfredo.newsapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.manfredo.newsapp.databinding.FragmentArticleBinding
import com.manfredo.newsapp.ui.MainActivity
import com.manfredo.newsapp.ui.NewsViewModel

class ArticleFragment : Fragment() {

    lateinit var binding: FragmentArticleBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleBinding.inflate(layoutInflater,container,false)
        setUpToolbar()
        return binding.root
    }

    private fun setUpToolbar() {
        binding.toolbar.apply {
            tvTitleToolbar.text = "NYTimes Article"
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as MainActivity).viewModel
    }
}