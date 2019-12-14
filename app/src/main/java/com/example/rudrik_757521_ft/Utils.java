package com.example.rudrik_757521_ft;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Collections;

public class Utils {

    private static Context context;

    public static ArrayList<Integer> userImages = new ArrayList<Integer>();
    public static ArrayList<Integer> lightImages = new ArrayList<Integer>();
    public static ArrayList<Integer> trafficLights = new ArrayList<Integer>();

    public static Integer refreshImg, checkedImg;

    public Utils(Context context) {
        this.context = context;
        addUserImages();
        addLightImages();
        addTrafficLights();

        refreshImg = R.drawable.refresh;
        checkedImg = R.drawable.checked;
    }

    private static void addUserImages() {
        userImages.add(R.drawable.icon01_01);
        userImages.add(R.drawable.icon01_02);
        userImages.add(R.drawable.icon01_03);
        userImages.add(R.drawable.icon01_04);
        userImages.add(R.drawable.icon01_05);
        userImages.add(R.drawable.icon01_06);
        userImages.add(R.drawable.icon01_07);
        userImages.add(R.drawable.icon01_08);
        userImages.add(R.drawable.icon01_09);
        userImages.add(R.drawable.icon01_10);
        userImages.add(R.drawable.icon01_11);
        userImages.add(R.drawable.icon01_12);
        userImages.add(R.drawable.icon01_13);
        userImages.add(R.drawable.icon01_14);
        userImages.add(R.drawable.icon01_15);
        userImages.add(R.drawable.icon01_16);
        userImages.add(R.drawable.icon01_17);
        userImages.add(R.drawable.icon01_18);
        userImages.add(R.drawable.icon01_19);
        userImages.add(R.drawable.icon01_20);
        userImages.add(R.drawable.icon01_21);
        userImages.add(R.drawable.icon01_22);
        userImages.add(R.drawable.icon01_23);
        userImages.add(R.drawable.icon01_24);
        userImages.add(R.drawable.icon01_25);
        userImages.add(R.drawable.icon01_26);
        userImages.add(R.drawable.icon01_27);
        userImages.add(R.drawable.icon01_28);
        userImages.add(R.drawable.icon01_29);
        userImages.add(R.drawable.icon01_30);
    }

    private static void addLightImages() {
        lightImages.add(R.drawable.img1);
        lightImages.add(R.drawable.img2);
        lightImages.add(R.drawable.img3);
        lightImages.add(R.drawable.img4);
        lightImages.add(R.drawable.img5);
        lightImages.add(R.drawable.img6);
        lightImages.add(R.drawable.img7);
        lightImages.add(R.drawable.img8);
        lightImages.add(R.drawable.img9);
    }

    private static void addTrafficLights(){
        trafficLights.add(R.drawable.img1);
        trafficLights.add(R.drawable.img2);
        trafficLights.add(R.drawable.img3);
        trafficLights.add(R.drawable.img4);
    }

    public static ArrayList<Integer> getShuffledUserImages(){
        ArrayList<Integer> shuffled = userImages;
        Collections.shuffle(shuffled);
        return shuffled;
    }

    public static ArrayList<Integer> getShuffledLightImages(){
        ArrayList<Integer> shuffled = lightImages;
        Collections.shuffle(shuffled);
        return shuffled;
    }
}
