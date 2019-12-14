package com.example.rudrik_757521_ft.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rudrik_757521_ft.R;
import com.example.rudrik_757521_ft.Utils;
import com.example.rudrik_757521_ft.models.User;

public class AdptUserList extends ArrayAdapter {
    private Context context;

    public AdptUserList(@NonNull Context context) {
        super(context, 0);
        this.context = context;
    }

    @Override
    public int getCount() {
        return User.listUsers.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View cv, @NonNull ViewGroup parent) {
        User u = User.listUsers.get(position);
        if (cv == null){
            cv = LayoutInflater.from(context).inflate(R.layout.item_user, null);
        }
        ImageView imgUser = cv.findViewById(R.id.imgUser);
        TextView txtUname = cv.findViewById(R.id.txtUname);
        TextView txtUemail = cv.findViewById(R.id.txtUemail);
        TextView txtUphone = cv.findViewById(R.id.txtUphone);

        imgUser.setImageDrawable(context.getDrawable(u.getAvatar()));
        txtUname.setText(u.getName());
        txtUemail.setText(u.getEmail());
        txtUphone.setText(u.getPhone());

        return cv;
    }
}
