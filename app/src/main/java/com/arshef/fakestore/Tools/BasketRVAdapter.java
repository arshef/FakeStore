package com.arshef.fakestore.Tools;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.arshef.fakestore.R;

public class BasketRVAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        static CardView cv;
        static TextView Title;
        static TextView Price;
        static ImageView Image;
        static Button AddBtn;

        ProductViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            Title = itemView.findViewById(R.id.productTitle);
            Price = itemView.findViewById(R.id.productPrice);
            Image = itemView.findViewById(R.id.productImage);
            AddBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
