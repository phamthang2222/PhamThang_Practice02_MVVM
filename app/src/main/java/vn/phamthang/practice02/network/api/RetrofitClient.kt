package vn.phamthang.practice02.network.api

import android.provider.SyncStateContract.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import vn.phamthang.practice02.BuildConfig
import vn.phamthang.practice02.contants.ConstantApi
import vn.phamthang.practice02.network.api.request.DummyService

class RetrofitClient {
    companion object{
        private val instance by lazy {
            val loggingInterceptor = HttpLoggingInterceptor()
            if(BuildConfig.DEBUG){
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }else{
                loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
            }

            val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
            Retrofit.Builder()
                .baseUrl(ConstantApi.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val getDummyApi:DummyService by lazy {
            instance.create(DummyService::class.java)
        }
    }
}