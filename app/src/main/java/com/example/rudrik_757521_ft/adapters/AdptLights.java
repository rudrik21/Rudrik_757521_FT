package com.example.rudrik_757521_ft.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.rudrik_757521_ft.R;
import com.example.rudrik_757521_ft.Utils;

import java.util.ArrayList;

public class AdptLights extends BaseAdapter{
    private Context context;
    private ArrayList<Integer> list;

    public AdptLights(Context context) {
        this.context = context;
        list = Utils.getShuffledLightImages();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View cv, ViewGroup parent) {
        Integer src = list.get(position);
        if (cv == null){
            cv = LayoutInflater.from(context).inflate(R.layout.item_light, null);
        }
        ImageView imgLight = cv.findViewById(R.id.imgLight);
        imgLight.setImageDrawable(context.getDrawable(src));

        imgLight.setLayoutParams(new AbsListView.LayoutParams(
                (int) (parent.getWidth() / 3),//DataUtils.num=3
                (int) (parent.getWidth() / 3)));
        imgLight.setScaleType(ImageButton.ScaleType.CENTER_CROP);

        if (Utils.trafficLights.contains(src)) {
            imgLight.setTag("TRAFFIC_LIGHT");
            Log.e("TAG", imgLight.getTag().toString());
        }else{
            imgLight.setTag("");
        }

        return cv;
    }
}
