package com.example.kisileruygulamas.data.datasource

import android.util.Log
import com.example.kisileruygulamas.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Ahmet","1111")
            val k2 = Kisiler(2,"Mehmet","2222")
            val k3 = Kisiler(3,"Ayşe","3333")
            val k4 = Kisiler(4,"Fatma","4444")

            kisilerListesi.add(k1)
            kisilerListesi.add(k2)
            kisilerListesi.add(k3)
            kisilerListesi.add(k4)
            return@withContext kisilerListesi
        }
    suspend fun ara(aramaKelimesi: String) : List<Kisiler> =
        withContext(Dispatchers.IO){
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Ahmet","1111")

            kisilerListesi.add(k1)

            return@withContext kisilerListesi
        }
    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")

    }
    suspend fun guncelle(kisi_id:Int ,kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Güncelle","$kisi_id -$kisi_ad - $kisi_tel")

    }

    suspend fun sil (kisi_id:Int){
        Log.e("Kişi Sil",kisi_id.toString())
    }
}