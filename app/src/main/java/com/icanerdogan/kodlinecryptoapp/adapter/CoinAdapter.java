package com.icanerdogan.kodlinecryptoapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.icanerdogan.kodlinecryptoapp.R;
import com.icanerdogan.kodlinecryptoapp.controller.CoinModel;
import java.util.List;
import io.reactivex.annotations.NonNull;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.CoinHolder> {

    private Context context;
    private List<CoinModel> coinList;

    public CoinAdapter(Context context, List<CoinModel> coinList) {
        this.context = context;
        this.coinList = coinList;
    }


    @androidx.annotation.NonNull
    @Override
    public CoinHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.coin_layout, parent, false);

        return new CoinHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull CoinHolder holder, int position) {

        int id = coinList.get(position).getId();
        String imageLink = "https://s2.coinmarketcap.com/static/img/exchanges/64x64/"+id+".png";
        Glide.with(context).load(imageLink).into(holder.imageViewCoin);

        holder.txtCoinName.setText(coinList.get(position).getName());
        holder.txtCoinSlugName.setText(coinList.get(position).getSlug());

        int active_state = coinList.get(position).getIs_active();

        if (active_state == 1){
            holder.imageActivityState.setBackgroundColor(Color.rgb(0, 255, 0));
        }
        else {
            holder.imageActivityState.setBackgroundColor(Color.rgb(255, 0, 0));
        }
        //holder.txtActivityState.setText(coinList.get(position).getIs_active());


    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }

    public class CoinHolder extends RecyclerView.ViewHolder{

        ImageView imageViewCoin, imageActivityState;
        TextView txtCoinName, txtCoinSlugName;

        public CoinHolder(@NonNull View itemView){
            super(itemView);

            imageViewCoin = itemView.findViewById(R.id.imageViewLogo);
            txtCoinName = itemView.findViewById(R.id.textViewCoinName);
            txtCoinSlugName = itemView.findViewById(R.id.textViewCoinShortName);
            imageActivityState = itemView.findViewById(R.id.textViewActivity);
        }
    }
}
