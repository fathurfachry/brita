package com.fachry.brita.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ujian.ui.NewsViewModel
import com.fachry.brita.adapter.NewsAdapter
import com.fachry.brita.data.repository.NewsRepository
import com.fachry.brita.databinding.FragmentMerdekaAutoBinding
import com.fachry.brita.utils.NewsViewModelFactory

class MerdekaAutoFragment : Fragment() {

    lateinit var binding: FragmentMerdekaAutoBinding
    private val merdekaViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMerdekaAutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()
        merdekaViewModel.getMerdekaAutoNews()

        merdekaViewModel.merdekaAutoNews.observe(viewLifecycleOwner) { dataNews ->
            dataNews?.data?.let { mAdapter.setData(it.posts) }
        }

        binding.rvMerdekaAuto.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        merdekaViewModel.isLoading.observe(viewLifecycleOwner){
            showLoading(it)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingView.root.visibility = View.VISIBLE
        } else {
            binding.loadingView.root.visibility = View.GONE
        }
    }


}