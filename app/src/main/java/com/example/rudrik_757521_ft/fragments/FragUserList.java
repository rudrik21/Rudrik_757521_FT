package com.example.rudrik_757521_ft.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rudrik_757521_ft.adapters.AdptUserList;
import com.example.rudrik_757521_ft.MainActivity;
import com.example.rudrik_757521_ft.R;
import com.example.rudrik_757521_ft.UserDetailsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragUserList extends Fragment implements AdapterView.OnItemClickListener {

    private static String TAG = "FragUserList";

    private View v;
    private ListView listViewUsers;
    private AdptUserList adpt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_frag_user_list, container, false);

        listViewUsers = (ListView) v.findViewById(R.id.listViewUsers);
        adpt = new AdptUserList(getContext());

        listViewUsers.setAdapter(adpt);
        listViewUsers.setOnItemClickListener(this);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MainActivity act = (MainActivity) getActivity();
        if (act.getFragUserDetails() != null) {
            if (act.getFragUserDetails().getView() == null) {
                Intent intent = new Intent(getContext(), UserDetailsActivity.class);
                intent.putExtra("SELECTED_POSITION", position);
                startActivity(intent);
            }else{
                act.getFragUserDetails().setDetails(position);
            }
        }else if (!act.isFragUserDetailsVisible){
            Intent intent = new Intent(getContext(), UserDetailsActivity.class);
            intent.putExtra("SELECTED_POSITION", position);
            startActivity(intent);
        }
    }

    public void update() {
        if (adpt != null){
            adpt.notifyDataSetChanged();
        }
    }
}
