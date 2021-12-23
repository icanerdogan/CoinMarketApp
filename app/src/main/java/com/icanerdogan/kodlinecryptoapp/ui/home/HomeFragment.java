package com.icanerdogan.kodlinecryptoapp.ui.home;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.icanerdogan.kodlinecryptoapp.R;
import com.icanerdogan.kodlinecryptoapp.adapter.CoinAdapter;
import com.icanerdogan.kodlinecryptoapp.controller.Api;
import com.icanerdogan.kodlinecryptoapp.controller.CoinModel;
import com.icanerdogan.kodlinecryptoapp.controller.MainCoinModel;
import com.icanerdogan.kodlinecryptoapp.databinding.FragmentHomeBinding;
import com.icanerdogan.kodlinecryptoapp.service.CoinService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding fragmentHomeBinding;
    List<CoinModel> coinList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = fragmentHomeBinding.getRoot();
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // Title Bar Logo
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.drawable.title_bar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayUseLogoEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#06162d")));
        // Title Bar Text
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);

        // Coin Data List on Home Fragment
        getCoinListData();
    }

    // HOME TUŞUNA SÜREKLİ BASARSAK UYGULAMA ÇÖKÜYOR!
    private void getCoinListData() {
        Retrofit retrofit = Api.getCoinRetrofit();

        CoinService coinService = retrofit.create(CoinService.class);
        Call<MainCoinModel> call = coinService.getData();
        call.enqueue(new Callback<MainCoinModel>() {
            @Override
            public void onResponse(Call<MainCoinModel> call, Response<MainCoinModel> response) {
                try {
                    if (!response.isSuccessful()){
                        Toast.makeText(getActivity(), response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }

                    MainCoinModel mainCoinModel = response.body();

                    if (mainCoinModel != null){
                        coinList = new ArrayList<>(Arrays.asList(mainCoinModel.getData()));
                        CoinAdapter coinAdapter = new CoinAdapter(getActivity(), coinList);

                        fragmentHomeBinding.recyclerViewHomeFragment.setHasFixedSize(true);
                        fragmentHomeBinding.recyclerViewHomeFragment.setLayoutManager(new LinearLayoutManager(getActivity()));
                        fragmentHomeBinding.recyclerViewHomeFragment.setAdapter(coinAdapter);
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Ağ Hatası", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MainCoinModel> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHomeBinding = null;
    }
}