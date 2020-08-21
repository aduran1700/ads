package com.digitalturbine.ads.ui.adslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.digitalturbine.ads.R
import com.digitalturbine.ads.data.model.Ad
import com.digitalturbine.ads.databinding.AdListItemBinding


class AdListRecyclerViewAdapter: RecyclerView.Adapter<AdListRecyclerViewAdapter.ViewHolder>() {

    private val adList = mutableListOf<Ad>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<AdListItemBinding>(
            inflater, R.layout.ad_list_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount() = adList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val conference = adList[position]
        holder.bind(conference)
    }

    fun updateList(updates: List<Ad>) {
        adList.clear()
        adList.addAll(updates)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: AdListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(ad: Ad) {
            binding.ad = ad
            binding.row.setOnClickListener {
                val action = AdListFragmentDirections
                    .actionAdListFragmentToAdDetailFragment(ad)

                it.findNavController().navigate(action)
            }

            binding.executePendingBindings()
        }
    }
}