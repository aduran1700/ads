package com.digitalturbine.ads.ui.adslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.digitalturbine.ads.R
import com.digitalturbine.ads.data.model.ResponseState
import com.digitalturbine.ads.di.vm.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_ad_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AdListFragment : DaggerFragment() {

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory<AdListViewModel>

    private val adListViewModel : AdListViewModel by lazy {
        ViewModelProvider(this, mViewModelFactory).get(AdListViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ad_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adListRecyclerViewAdapter = AdListRecyclerViewAdapter()

        ad_list.apply {
            adapter = adListRecyclerViewAdapter
        }

        adListViewModel.adResponse.observe(viewLifecycleOwner, Observer { it ->
            when (it) {
                is ResponseState.Success -> {
                    ad_list.visibility = View.VISIBLE
                    progress_circular.visibility = View.GONE
                    adListRecyclerViewAdapter.updateList(it.list)
                }
                is ResponseState.Error -> {
                    Snackbar.make(ad_list, it.error.toString(), Snackbar.LENGTH_LONG).show()
                    progress_circular.visibility = View.GONE
                }
                is ResponseState.Loading -> {
                    progress_circular.visibility = View.VISIBLE
                    ad_list.visibility  = View.GONE
                }
                is ResponseState.Empty -> {
                    Snackbar.make(ad_list, getString(R.string.empty_list_text),
                        Snackbar.LENGTH_INDEFINITE).setAction(R.string.retry) {
                        adListViewModel.getAdListData()
                    }.show()

                    progress_circular.visibility = View.GONE
                }
            }
        })

        adListViewModel.getAdListData()
    }
}