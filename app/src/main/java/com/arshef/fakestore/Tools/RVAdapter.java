package com.arshef.fakestore.Tools;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProductViewHolder> {

    List<Product> Products;

    public RVAdapter(List<Product> products) {
        Products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        ProductViewHolder.Title.setText(Products.get(i).getTitle());
        ProductViewHolder.Price.setText(String.valueOf(Products.get(i).getPrice()));
        if (Products.get(i).getImage() != null) {
            ProductViewHolder.Image.setImageBitmap(StaticTools.GetImageFromBytes(Products.get(i).getImage(), 60, 60));
        }
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        static CardView cv;
        static TextView Title;
        static TextView Price;
        static ImageView Image;

        ProductViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            Title = itemView.findViewById(R.id.productTitle);
            Price = itemView.findViewById(R.id.productPrice);
            Image = itemView.findViewById(R.id.productImage);
        }
    }
}
