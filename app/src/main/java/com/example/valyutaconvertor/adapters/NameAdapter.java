package com.example.valyutaconvertor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.valyutaconvertor.R;
import com.example.valyutaconvertor.models.Models;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.MyHv> {
    private List<Models> list = new ArrayList<>();
    public NameAdapter(List<Models> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyHv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_valyuta, parent, false);
        return new MyHv(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHv holder, int position) {
        holder.name.setText(list.get(position).name);
        holder.value.setText("1 " + list.get(0).name + " = " +list.get(position).value.toString());
        holder.valyuta.setText(list.get(position).valyuta);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHv extends RecyclerView.ViewHolder{
        TextView name, value, valyuta;
        public MyHv(@NonNull View itemView) {
            super(itemView);
             name = itemView.findViewById(R.id.name_tv);
             value = itemView.findViewById(R.id.value_tv);
             valyuta = itemView.findViewById(R.id.valyuta_tv);
        }
    }
}
