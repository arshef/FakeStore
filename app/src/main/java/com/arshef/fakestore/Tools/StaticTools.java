package com.arshef.fakestore.Tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.arshef.fakestore.Models.Basket;
import com.arshef.fakestore.Models.Product;
import com.arshef.fakestore.Models.ProductBasket;
import com.arshef.fakestore.Models.User;
import com.google.android.gms.maps.model.LatLng;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StaticTools {
    public static void ToastMaker(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static Bitmap GetImageFromBytes(byte[] byteArray, int width, int height) {
        if (byteArray.length == 0) return null;
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Bitmap bitmap = Bitmap.createScaledBitmap(bmp, width, height, false);
        return bitmap;
    }

    public static byte[] GetBytesFromImage(Bitmap bitmap, int quality) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, quality, stream);
        return stream.toByteArray();
    }


    public static boolean Authenticate(String username) {
        if (User.find(User.class, "Username = ?", username).size() > 0) {
            return true;
        }
        return false;
    }

    public static int getDistance(LatLng pos, LatLng myPos) {
        int r = (int) Math.round((distance(pos.latitude, myPos.latitude, pos.longitude, myPos.longitude, 0, 0)) / 1000);
        return r;
    }

    private static double distance(double lat1, double lat2, double lon1,
                                   double lon2, double el1, double el2) {
        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
        double height = el1 - el2;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        return Math.sqrt(distance);
    }

    public static void AddToBasket(long i) {
        Product product = Product.findById(Product.class, i + 1);
        User user = User.findById(User.class, 1);
        //kolan basket nadasht
        if (user.Basket == null) {
            List<ProductBasket> products = new ArrayList<>();
            ProductBasket pb = new ProductBasket(product);
            products.add(pb);
            Basket basket = new Basket(products);
            basket.setPrice(product.getPrice());
            User.Basket = basket;
        } else {
            List<ProductBasket> products = User.Basket.getProducts();
            ProductBasket productBasket = null;
            for (ProductBasket j :
                    User.Basket.getProducts()) {
                if (j.getProduct().getId().equals(product.getId())) {
                    j.setCount(j.getCount() + 1);
                    return;
                }
            }
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
}
