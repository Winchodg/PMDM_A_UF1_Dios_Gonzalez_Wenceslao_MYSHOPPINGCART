package com.example.myshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myshoppingcart.databinding.FragmentBreadBinding
import com.example.myshoppingcart.databinding.FragmentVegetablesBinding

class BreadFragment : Fragment() {
    private var _binding: FragmentBreadBinding? = null
    private val binding: FragmentBreadBinding
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
        _binding= FragmentBreadBinding.inflate(inflater, container, false)
        val view = binding.root

        val btnAddToCart = binding.buttonAdd2


        btnAddToCart.setOnClickListener {
            val vegetable = binding.spinnerBread.selectedItemPosition
            val product = binding.spinnerBread.selectedItem.toString()

            var price = when (vegetable) {
                0 -> 1.00f
                1 -> 1.50f
                2 -> 0.70f
                else -> 1.25f
            }

            val amount = when (true) {
                binding.radio1ud.isChecked-> getString(R.string.amount4)
                binding.radio2ud.isChecked -> getString(R.string.amount5)
                binding.radio3ud.isChecked -> getString(R.string.amount6)
                else -> ""
            }

            if (binding.radio2ud.isChecked) {
                price *= 2
            } else if (binding.radio3ud.isChecked) {
                price *= 3
            }

            val action = BreadFragmentDirections.actionBreadFragmentToCartFragment(
                product,
                price,
                amount
            )
            view.findNavController().navigate(action)

        }

        return view
    }
}