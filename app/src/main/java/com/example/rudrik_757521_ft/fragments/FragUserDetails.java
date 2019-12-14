package com.example.rudrik_757521_ft.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rudrik_757521_ft.R;
import com.example.rudrik_757521_ft.Utils;
import com.example.rudrik_757521_ft.models.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragUserDetails extends Fragment {

    private static String TAG = "FragUserDetails";

    private View v;
    private int pos = -1;
    private User user;

    private ImageView imgUserUD;
    private TextView txtUnameUD;
    private TextView txtUemailUD;
    private TextView txtUphoneUD;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_frag_user_details, container, false);
        pos = getActivity().getIntent().getIntExtra("SELECTED_POSITION", -1);

        return v;
    }

    public void setDetails(int position){
        this.pos = position;
        setData();
        Log.e(TAG, "setDetails: " + String.valueOf(position));
    }

    private void setData(){
        imgUserUD = (ImageView)  v.findViewById(R.id.imgUserUD);
        txtUnameUD = (TextView)  v.findViewById(R.id.txtUnameUD);
        txtUemailUD = (TextView) v.findViewById(R.id.txtUemailUD);
        txtUphoneUD = (TextView) v.findViewById(R.id.txtUphoneUD);

        if (pos > -1) {
            user = User.listUsers.get(pos);
            imgUserUD.setImageDrawable(getContext().getDrawable(user.getAvatar()));
            txtUnameUD.setText(user.getName());
            txtUemailUD.setText(user.getEmail());
            txtUphoneUD.setText(user.getPhone());
        }
    }
}
