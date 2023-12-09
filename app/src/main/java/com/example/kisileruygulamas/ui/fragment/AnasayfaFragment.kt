package com.example.kisileruygulamas.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.kisileruygulamas.R
import com.example.kisileruygulamas.data.entity.Kisiler
import com.example.kisileruygulamas.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitFragment)// it yerine binding.fab yazılabilr
        }

        binding.buttonDetay.setOnClickListener {
            val kisi = Kisiler(1,"ahmet","1111")
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }


        return binding.root

    }

}