package com.example.myshoppingcart

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.myshoppingcart.databinding.FragmentCartBinding
import com.example.myshoppingcart.databinding.FragmentVegetablesBinding
import com.google.android.material.snackbar.Snackbar


class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding: FragmentCartBinding
        get() = _binding!!

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_cart, container, false)
        _binding= FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root
        //val message = view.findViewById<TextView>(R.id.message)
        val textView = binding.message

        val product = CartFragmentArgs.fromBundle(requireArguments()).product
        val price = CartFragmentArgs.fromBundle(requireArguments()).price
        val amount = CartFragmentArgs.fromBundle(requireArguments()).amount


        val message = textView.text.toString()

        if (amount == "") {
            val warning = getString(R.string.warning)
            textView.setText(warning)
            Toast.makeText(activity, warning, Toast.LENGTH_LONG).show();
        }
        else {

            val msg = product +
                    " " +price.toString()+"€"
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
            textView.setText(message + msg.toString() + " ("+amount+")")

            when (product){
                getString(R.string.tomato) -> binding.productImage.setImageResource(R.drawable.tomate)
                getString(R.string.onions) -> binding.productImage.setImageResource(R.drawable.cebollas)
                getString(R.string.leeks) -> binding.productImage.setImageResource(R.drawable.puerros)
                getString(R.string.garlic) -> binding.productImage.setImageResource(R.drawable.ajos)
                getString(R.string.wheat_bread) -> binding.productImage.setImageResource(R.drawable.pan_trigo)
                getString(R.string.rye_bread) -> binding.productImage.setImageResource(R.drawable.pan_centeno)
                getString(R.string.hamburguer_bun) -> binding.productImage.setImageResource(R.drawable.bollo_burger)
                getString(R.string.white_bread) -> binding.productImage.setImageResource(R.drawable.pan_blanco)
                getString(R.string.beef) -> binding.productImage.setImageResource(R.drawable.carne_ternera)
                getString(R.string.pork) -> binding.productImage.setImageResource(R.drawable.carne_cerdo)
                getString(R.string.chicken) -> binding.productImage.setImageResource(R.drawable.carne_pollo)
                getString(R.string.lamb) -> binding.productImage.setImageResource(R.drawable.carne_cordero)
                getString(R.string.sardines) -> binding.productImage.setImageResource(R.drawable.sardinas)
                getString(R.string.tuna) -> binding.productImage.setImageResource(R.drawable.atun)
                getString(R.string.salmon) -> binding.productImage.setImageResource(R.drawable.salmon)
                getString(R.string.sea_bass) -> binding.productImage.setImageResource(R.drawable.lubina)

            }
        }

        return view
    }
}