package com.example.valyutaconvertor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.valyutaconvertor.R;
import com.example.valyutaconvertor.models.KreditHisobot;

import java.util.ArrayList;
import java.util.List;

public class KreditAdapter extends RecyclerView.Adapter<KreditAdapter.MyView> {
    private List<KreditHisobot> list = new ArrayList<>();

    public KreditAdapter(List<KreditHisobot> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calculator_item, parent, false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.oy.setText(list.get(position).getSon());
        holder.tolov.setText(list.get(position).getTolov());
        holder.asosiy.setText(list.get(position).getAsosiyQarz());
        holder.foiz.setText(list.get(position).getFoiz());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyView extends RecyclerView.ViewHolder {
        TextView oy, tolov, asosiy, foiz;
        public MyView(@NonNull View itemView) {
            super(itemView);
            oy = itemView.findViewById(R.id.oy_tv);
            tolov = itemView.findViewById(R.id.oylik_tv);
            asosiy = itemView.findViewById(R.id.asosiy_tv);
            foiz = itemView.findViewById(R.id.foiz_tv);

        }
    }
}
