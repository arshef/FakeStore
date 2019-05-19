package com.arshef.fakestore.Tools;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arshef.fakestore.Models.ProductBasket;
import com.arshef.fakestore.R;

import java.util.List;

public class BasketRVAdapter extends RecyclerView.Adapter<BasketRVAdapter.BasketProductViewHolder> {


    List<ProductBasket> PBs;
    android.content.Context Context;

    public BasketRVAdapter(List<ProductBasket> productBaskets, android.content.Context context) {
        PBs = productBaskets;
        Context = context;
    }

    @NonNull
    @Override
    public BasketProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.basket_card_view, viewGroup, false);
        BasketProductViewHolder bpvh = new BasketProductViewHolder(v);
        return bpvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BasketProductViewHolder basketProductViewHolder, int i) {
        basketProductViewHolder.setIsRecyclable(false);
        ProductBasket pb = PBs.get(i);
        BasketProductViewHolder.Title.setText(pb.getProduct().getTitle());
        BasketProductViewHolder.Count.setText(String.valueOf(pb.getCount()));
        BasketProductViewHolder.Price.setText(String.format("%s T", String.valueOf(pb.getProduct().getPrice())));
        if (pb.getProduct().getImage() != null) {
            BasketProductViewHolder.Image.setImageBitmap(StaticTools.GetImageFromBytes(pb.getProduct().getImage(), 60, 60));
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return PBs.size();
    }

    public static class BasketProductViewHolder extends RecyclerView.ViewHolder {
        static CardView cv;
        static TextView Title;
        static TextView Price;
        static ImageView Image;
        static TextView Count;

        BasketProductViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.basket_cv);
            Title = itemView.findViewById(R.id.basketProductTitle);
            Price = itemView.findViewById(R.id.basketProductPrice);
            Image = itemView.findViewById(R.id.basketProductImage);
            Count = itemView.findViewById(R.id.basketCount);
        }
    }
}
