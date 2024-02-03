package com.example.kisileruygulamas.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener

import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamas.R
import com.example.kisileruygulamas.data.entity.Kisiler
import com.example.kisileruygulamas.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamas.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa ,container, false)
        binding.anasayfaFragment = this


        binding.anasayfaToolbarBaslik = "Kişiler"

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Mehmet","2222")
        val k3 = Kisiler(3,"Ayşe","3333")
        val k4 = Kisiler(4,"Fatma","4444")

        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)

        val kisilerAdapter = KisilerAdapter(requireContext(),kisilerListesi)

        binding.kisilerAdapter = kisilerAdapter



        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })



        return binding.root
    }
    fun ara(aramaKelimesi: String){
        Log.e("Kişi Ara",aramaKelimesi)
    }
    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitFragment)
    }
}