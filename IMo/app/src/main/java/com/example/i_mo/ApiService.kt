package com.example.i_mo

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products/category/electronics")
    fun getElectronics(): Call<List<Product>>
}
