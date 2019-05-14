package com.arshef.fakestore.Tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.arshef.fakestore.Models.User;

import java.io.ByteArrayOutputStream;

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

}
