package com.example.activity8.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activity8.MainActivity;
import com.example.activity8.R;
import com.example.activity8.database.Teman;
import com.example.activity8.database.dbController;
import com.example.activity8.editTeman;

import java.util.ArrayList;
import java.util.HashMap;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.temanViewHolder> {
    private ArrayList<Teman> listData;

    public TemanAdapter(ArrayList<Teman> listData) {
        this.listData = listData;
    }

    @Override
    public temanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_teman,parent,false);
        return new temanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TemanAdapter.temanViewHolder holder, int position) {
        String nm, tlp, id;

        id = listData.get(position).getId();
        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelepon();

        holder.txtNama.setTextColor(Color.BLUE);
        holder.txtNama.setTextSize(20);
        holder.txtNama.setText(nm);
        holder.txtTelepon.setText(tlp);

        holder.cardKu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return true;

            }
        });
    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    public class temanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardKu;
        private TextView txtNama, txtTelepon;

        public temanViewHolder(View view) {
            super(view);
            cardKu = (CardView) view.findViewById(R.id.myCard);
            txtNama = (TextView) view.findViewById(R.id.textNama);
            txtTelepon = (TextView) view.findViewById(R.id.textTelepon);
        }
    }

}
