package com.example.myshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myshoppingcart.databinding.FragmentVegetablesBinding

class VegetablesFragment : Fragment() {
    private var _binding:FragmentVegetablesBinding? = null
    private val binding: FragmentVegetablesBinding
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
        //val view = inflater.inflate(R.layout.fragment_vegetables, container, false)

        _binding= FragmentVegetablesBinding.inflate(inflater, container, false)
        val view = binding.root

        val btnAddToCart = binding.buttonAdd


        btnAddToCart.setOnClickListener {
            val vegetable = binding.spinnerVegetables.selectedItemPosition
            val product = binding.spinnerVegetables.selectedItem.toString()

            var price =  when (vegetable) {
                0 -> 2.95f
                1 -> 3.45f
                2 -> 3.95f
                else-> 1.65f
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

            val action = VegetablesFragmentDirections.actionVegetablesFragmentToCartFragment(product, price, amount)
            view.findNavController().navigate(action)

        }

        return view
    }
}