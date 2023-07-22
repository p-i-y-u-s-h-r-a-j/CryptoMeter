package com.example.cryptometer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.cryptometer.adapter.MarketAdapter
import com.example.cryptometer.api.ApiInterface
import com.example.cryptometer.api.ApiUtility
import com.example.cryptometer.databinding.FragmentTopLossGainBinding
import com.example.cryptometer.fragment.models.CryptoCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Collections


class TopLossGainFragment : Fragment() {
    lateinit var binding: FragmentTopLossGainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopLossGainBinding.inflate(layoutInflater)
        getMarketData()
        return binding.root
    }

    private fun getMarketData() {
        val position = requireArguments().getInt("position").toInt()
        lifecycleScope.launch(Dispatchers.IO) {
            val res = ApiUtility.getInstance().create(ApiInterface::class.java).getMarketData()

            if(res.body()!=null){

                withContext(Dispatchers.Main){
                    val dataItem = res.body()!!.data?.cryptoCurrencyList

                    Collections.sort(dataItem) {
                            item1, item2 -> (item2.quotes?.get(0)?.percentChange24h!!.toInt())
                            .compareTo(item1.quotes?.get(0)?.percentChange24h!!.toInt())
                    }
                        binding.spinKitView.visibility = GONE
                        val list = ArrayList<CryptoCurrency>()

                        if(position == 0){
                            list.clear()
                            for(i in 0..20){
                                list.add(dataItem!![i])
                            }
                            binding.topGainLoseRecyclerView.adapter = MarketAdapter(
                                requireContext(),
                                list,
                                "home"
                            )
                        }
                        else{
                            list.clear()
                            for(i in 0..20){
                                list.add(dataItem!![dataItem.size-1-i])
                            }
                            binding.topGainLoseRecyclerView.adapter = MarketAdapter(
                                requireContext(),
                                list,
                                "home"
                            )
                        }


                }
            }
        }
    }
}