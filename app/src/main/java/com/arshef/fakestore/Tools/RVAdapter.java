package com.arshef.fakestore.Tools;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.arshef.fakestore.Activities.BasketActivity;
import com.arshef.fakestore.Models.Basket;
import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.Models.ProductBasket;
import com.arshef.fakestore.Models.User;
import com.arshef.fakestore.R;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProductViewHolder> {

    List<Product> Products;
    Context Context;

    public RVAdapter(List<Product> products, android.content.Context context) {
        Products = products;
        Context = context;
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
        final int id = i;
        productViewHolder.setIsRecyclable(false);
        productViewHolder.AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddToBasket(id);
                Intent intent = new Intent(Context, BasketActivity.class);
                Context.startActivity(intent);
            }
        });
        ProductViewHolder.Title.setText(Products.get(i).getTitle());
        ProductViewHolder.Price.setText(String.format("%s T", String.valueOf(Products.get(i).getPrice())));
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

    private void AddToBasket(long i) {
        Product product = Product.findById(Product.class, i + 1);
//        User user = User.find(User.class, "Username = ?", LoginActivity.user).get(0);
        User user = User.findById(User.class, 1);
        //kolan basket nadasht
        if (user.Basket == null) {
            List<ProductBasket> products = new ArrayList<>();
            ProductBasket pb = new ProductBasket(product);
            products.add(pb);
            Basket basket = new Basket(products);
            basket.setPrice(product.getPrice());
            User.Basket = basket;
            return;
        } else {
            List<ProductBasket> products = User.Basket.getProducts();
            ProductBasket productBasket = null;
            ProductBasket pb = new ProductBasket(product);
            products.add(pb);
            User.Basket.setProducts(products);
            int price = 0;
            for (ProductBasket p :
                    User.Basket.getProducts()) {
                price += p.getProduct().getPrice() * p.getCount();
            }
            User.Basket.setPrice(price);
        }
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
