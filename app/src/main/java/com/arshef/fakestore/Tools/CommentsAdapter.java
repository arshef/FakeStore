package com.arshef.fakestore.Tools;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.arshef.fakestore.R;

import java.util.List;

public class CommentsAdapter extends ArrayAdapter<String> {
    Context context;

    public CommentsAdapter(@NonNull Context context, @NonNull List<String> objects) {
        super(context, R.layout.adapter_item, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);

        return convertView;
    }
}
