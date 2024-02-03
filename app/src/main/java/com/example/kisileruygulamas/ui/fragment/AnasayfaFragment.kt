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
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamas.R
import com.example.kisileruygulamas.data.entity.Kisiler
import com.example.kisileruygulamas.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamas.ui.adapter.KisilerAdapter
import com.example.kisileruygulamas.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamas.ui.viewmodel.KisiKayitViewModel

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa ,container, false)
        binding.anasayfaFragment = this
        binding.anasayfaToolbarBaslik = "Kişiler"

      viewModel.kisilerListesi.observe(viewLifecycleOwner){
          val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)

          binding.kisilerAdapter = kisilerAdapter
      }





        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitFragment)
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }
}