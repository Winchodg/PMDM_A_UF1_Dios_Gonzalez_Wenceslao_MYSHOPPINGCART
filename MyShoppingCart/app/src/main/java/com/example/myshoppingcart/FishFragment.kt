package com.example.myshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myshoppingcart.databinding.FragmentFishBinding
import com.example.myshoppingcart.databinding.FragmentMeatBinding

class FishFragment : Fragment() {

    var _binding: FragmentFishBinding? = null
    val binding: FragmentFishBinding
        get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFishBinding.inflate(inflater, container, false)
        val view = binding.root

        val btnAddToCart = binding.buttonAdd4


        btnAddToCart.setOnClickListener {
            val vegetable = binding.spinnerFish.selectedItemPosition
            val product = binding.spinnerFish.selectedItem.toString()

            var price = when (vegetable) {
                0 -> 5.50f
                1 -> 7.95f
                2 -> 14.95f
                else -> 21.90f
            }

            val amount = when (true) {
                binding.radio1kg.isChecked -> getString(R.string.amount1)
                binding.radio2kg.isChecked -> getString(R.string.amount2)
                binding.radio3kg.isChecked -> getString(R.string.amount3)
                else -> ""
            }

            if (binding.radio2kg.isChecked) {
                price *= 2
            } else if (binding.radio3kg.isChecked) {
                price *= 3
            }

            val action =
                FishFragmentDirections.actionFishFragmentToCartFragment(product, price, amount)
            view.findNavController().navigate(action)

        }
        return view

    }
}