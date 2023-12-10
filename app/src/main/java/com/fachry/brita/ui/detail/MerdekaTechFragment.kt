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
import com.fachry.brita.databinding.FragmentMerdekaTechBinding
import com.fachry.brita.utils.NewsViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MerdekaTechFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MerdekaTechFragment : Fragment() {

    lateinit var binding: FragmentMerdekaTechBinding
    private val merdekaViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMerdekaTechBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()
        merdekaViewModel.getMerdekaTechNews()

        merdekaViewModel.merdekaTechNews.observe(viewLifecycleOwner) { dataNews ->
            dataNews?.data?.let { mAdapter.setData(it.posts) }
        }

        binding.rvMerdekaTech.apply {
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