package com.arshef.fakestore.Tools;

import android.content.Context;
import android.widget.Toast;

public class StaticTools {
    public static void ToastMaker(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
