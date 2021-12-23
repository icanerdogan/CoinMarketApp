package com.icanerdogan.kodlinecryptoapp.controller;

import com.google.gson.annotations.SerializedName;

public class CoinModel {
    /*
    {
         "id":16,
         "name":"Poloniex",
         "slug":"poloniex",
         "is_active":1,
     }
    */

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("slug")
    public String slug;
    @SerializedName("is_active")
    public int is_active;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public int getIs_active() {
        return is_active;
    }

}
