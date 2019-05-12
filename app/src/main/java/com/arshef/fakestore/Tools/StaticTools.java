package com.arshef.fakestore.Tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.arshef.fakestore.Models.User;

public class StaticTools {
    public static void ToastMaker(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static Bitmap GetImageFromBytes(byte[] byteArray, int width, int height) {
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Bitmap bitmap = Bitmap.createScaledBitmap(bmp, width, height, false);
        return bitmap;
    }


    public static boolean Authenticate(String username) {
        if (User.find(User.class, "Username = ?", username).size() > 0) {
            return true;
        }
        return false;
    }

}
