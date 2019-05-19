package com.arshef.fakestore.Tools;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.arshef.fakestore.Activities.DetailsActivity;
import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.R;

import java.util.List;

public class StoreRVAdapter extends RecyclerView.Adapter<StoreRVAdapter.ProductViewHolder> {

    List<Product> Products;
    Context Context;

    public StoreRVAdapter(List<Product> products, android.content.Context context) {
        Products = products;
        Context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_card_view, viewGroup, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        final int id = i;
        productViewHolder.setIsRecyclable(false);
        productViewHolder.AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Context, DetailsActivity.class);
                intent.putExtra("id", id);
                Context.startActivity(intent);
            }
        });
        Product product = Products.get(i);
        ProductViewHolder.Title.setText(product.getTitle());
        ProductViewHolder.Price.setText(String.format("%s T", String.valueOf(product.getPrice())));
        if (product.getImage() != null) {
            ProductViewHolder.Image.setImageBitmap(StaticTools.GetImageFromBytes(product.getImage(), 60, 60));
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
        static ImageButton AddBtn;

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
