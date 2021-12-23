package com.icanerdogan.kodlinecryptoapp.controller;

import com.google.gson.annotations.SerializedName;

public class MainCoinModel {
    @SerializedName("data")
    private CoinModel[] data;

    public CoinModel[] getData() {
        return data;
    }

    public void setData(CoinModel[] data) {
        this.data = data;
    }
}
