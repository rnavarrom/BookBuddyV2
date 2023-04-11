package com.example.bookbuddyv2.API

import com.example.bookbuddyv2.Model.UserList
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class CrudApi(): CoroutineScope {

    val urlapi = "https://172.16.24.120:7137/api/"

    private var job: Job = Job()

    suspend fun getUsers(): UserList {
        val response = getRetrofit().create(APIService::class.java).getUsers().body()
        return response!!
    }

    /*
    suspend fun getTipusFromApi(tipus: Int): Productes {
           val response = getRetrofit().create(APIService::class.java).getTipus(tipus).body()
           return response!!
    }

    suspend fun getAllFromAPI(): Productes {
        val response = getRetrofit().create(APIService::class.java).getProductes().body()
        return response!!
    }
    */
    private fun getRetrofit(): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder().baseUrl(urlapi).client(getClient())
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    private fun getClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(logging)
            .build()


    /*
    suspend fun getCodiFromApi(codi: Int): ArrayList<Producte> {
                val response = getRetrofit().create(APIService::class.java).getProducte(codi).body()
                return response!!
    }

    suspend fun addProducteToAPI(producte: Producte): Boolean {
        val call = getRetrofit().create(APIService::class.java).insertProducte(producte)
        return call.isSuccessful
    }

    suspend fun modifyProducteFromApi(producte: Producte): Boolean {
        val call = getRetrofit().create(APIService::class.java).updateProducte(producte)
        return call.isSuccessful
    }

    suspend fun esborraProducteAPI(codi: Int): Boolean {
        val call = getRetrofit().create(APIService::class.java).deleteProducte(codi)
        return call.isSuccessful
    }
    */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job


}

