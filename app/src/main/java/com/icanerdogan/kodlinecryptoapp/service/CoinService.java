package com.icanerdogan.kodlinecryptoapp.service;

import com.icanerdogan.kodlinecryptoapp.controller.MainCoinModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinService {
    @GET("v1/exchange/map?CMC_PRO_API_KEY=717ae232-c666-42b0-8d0c-ecca1a267bd2")
    Call<MainCoinModel> getData();
}
