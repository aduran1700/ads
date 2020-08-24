package com.digitalturbine.ads.ui.adsdetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.digitalturbine.ads.R
import com.digitalturbine.ads.databinding.FragmentAdDetailBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AdDetailFragment : Fragment() {

    val args: AdDetailFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAdDetailBinding>(
            inflater, R.layout.fragment_ad_detail, container, false)

        binding.ad = args.Ad
        binding.executePendingBindings()
        binding.actionButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(args.Ad.clickProxyURL)
            ContextCompat.startActivity(it.context, intent, null)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = activity?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar?.setNavigationOnClickListener {
            toolbar.navigationIcon = null
            findNavController().navigateUp()
        }
    }

}