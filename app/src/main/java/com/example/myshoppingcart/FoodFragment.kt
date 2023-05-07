package com.example.myshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.findNavController

class FoodFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food, container, false)

        val btnFruVeg = view.findViewById<ImageButton>(R.id.frutas_verduras)
        val btnBread = view.findViewById<ImageButton>(R.id.pan)
        val btnMeat = view.findViewById<ImageButton>(R.id.carne)
        val btnFish = view.findViewById<ImageButton>(R.id.pescado)

        btnFruVeg.setOnClickListener {
            view.findNavController().navigate(R.id.action_foodFragment_to_vegetablesFragment)
        }

        btnBread.setOnClickListener {
            view.findNavController().navigate(R.id.action_foodFragment_to_breadFragment)
        }

        btnMeat.setOnClickListener {
            view.findNavController().navigate(R.id.action_foodFragment_to_meatFragment)
        }

        btnFish.setOnClickListener {
            view.findNavController().navigate(R.id.action_foodFragment_to_fishFragment)
        }

        return view
    }
}