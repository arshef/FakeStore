package com.arshef.fakestore.Tools;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.arshef.fakestore.Activities.BasketActivity;
import com.arshef.fakestore.Activities.LoginActivity;
import com.arshef.fakestore.Models.Basket;
import com.arshef.fakestore.Models.Product;
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
        User user = User.find(User.class, "Username = ?", LoginActivity.user).get(0);
        long i1 = user.getId();
        if (user.getBaskets() == null) {
            List<Product> products = new ArrayList<>();
            products.add(product);
            Basket basket = new Basket(products);
            basket.setPrice(product.getPrice());
            List<Basket> baskets = new ArrayList<>();
            baskets.add(basket);
            user.setBaskets(baskets);
            Long id = user.save();
            if (i1 == id) {
                int a = 2 + 3;
            }
            //todo update user
            Log.wtf("id", String.valueOf(id));
            return;
        } else {
            List<Basket> baskets = user.getBaskets();
            Basket basket = null;
            for (Basket b :
                    baskets) {
                if (b.isActive()) {
                    basket = b;
                    break;
                }
            }
            if (basket == null) {
                List<Product> products = new ArrayList<>();
                products.add(product);
                Basket basket1 = new Basket(products);
                basket1.setPrice(product.getPrice());
                baskets.add(basket1);
                user.setBaskets(baskets);
                user.update();
            } else {
                List<Product> products = basket.getProducts();
                products.add(product);
                basket.setProducts(products);
                int price = 0;
                for (Basket b :
                        baskets) {
                    price += b.getPrice();
                }
                basket.setPrice(price);
                user.setBaskets(baskets);
                user.update();
            }
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
