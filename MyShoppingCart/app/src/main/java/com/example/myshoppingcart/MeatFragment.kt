package com.example.myshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myshoppingcart.databinding.FragmentMeatBinding
import com.example.myshoppingcart.databinding.FragmentVegetablesBinding

class MeatFragment : Fragment() {
    var _binding:FragmentMeatBinding? = null
    val binding:FragmentMeatBinding
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
        _binding= FragmentMeatBinding.inflate(inflater, container, false)
        val view = binding.root

        val btnAddToCart = binding.buttonAdd3


        btnAddToCart.setOnClickListener {
            val vegetable = binding.spinnerMeat.selectedItemPosition
            val product = binding.spinnerMeat.selectedItem.toString()

            var price =  when (vegetable) {
                0 -> 9.50f
                1 -> 7.65f
                2 -> 5.15f
                else-> 10.75f
            }

            val amount =  when (true) {
                binding.radio1kg.isChecked -> getString(R.string.amount1)
                binding.radio2kg.isChecked -> getString(R.string.amount2)
                binding.radio3kg.isChecked -> getString(R.string.amount3)
                else -> ""
            }

            if (binding.radio2kg.isChecked) {
                price *= 2
            }
            else if (binding.radio3kg.isChecked) {
                price *= 3
            }

            val action = MeatFragmentDirections.actionMeatFragmentToCartFragment2(product, price, amount)
            view.findNavController().navigate(action)

        }
        return view
    }
}