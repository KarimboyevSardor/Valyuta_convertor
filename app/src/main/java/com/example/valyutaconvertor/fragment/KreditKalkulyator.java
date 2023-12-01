package com.example.valyutaconvertor.fragment;

import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormat;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.valyutaconvertor.R;
import com.example.valyutaconvertor.adapters.KreditAdapter;
import com.example.valyutaconvertor.databinding.FragmentKreditKalkulyatorBinding;
import com.example.valyutaconvertor.models.KreditHisobot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KreditKalkulyator extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public KreditKalkulyator() {
    }

    public static KreditKalkulyator newInstance(String param1, String param2) {
        KreditKalkulyator fragment = new KreditKalkulyator();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentKreditKalkulyatorBinding binding = null;
    List<KreditHisobot> kreditHisobotList = new ArrayList<>();
    KreditAdapter kreditAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKreditKalkulyatorBinding.inflate(inflater, container,false);

        binding.hisoblashBtn.setOnClickListener(v -> {
            kreditHisobotList = new ArrayList<>();
            String foiz = binding.foizEt.getText().toString();
            String summa = binding.kreditSummasiEt.getText().toString();
            String data = binding.vaqtEt.getText().toString();
            if (foiz.length() > 0&& summa.length() > 0 && data.length() > 0) {
                double aslQarz = Double.parseDouble(summa);
                double aslFoiz = Double.parseDouble(foiz);
                double aslOy = Double.parseDouble(data);
                double oylikFoiz = Double.parseDouble(foiz) / Double.parseDouble(data);
                double oylikTolov = Double.parseDouble(summa) / Double.parseDouble(data);
                double tolovFoiz = 0;
                double ozgaruvchiFoiz = 0;
                double oylikFoizTolov = 0;
                double jamiQarz = 0;
                double jamiFoiz = 0;
                DecimalFormat numberFormat = new DecimalFormat(".00");
                kreditHisobotList.add(new KreditHisobot("#",  "Oylik tolov", "Asosiy qarz", "Foiz qarz"));
                for (int i = 1; i <= Double.parseDouble(data); i++) {
                    tolovFoiz = ((aslQarz * ((aslFoiz - (ozgaruvchiFoiz)) / aslOy)) / 100) + (aslQarz / aslOy);
                    oylikFoizTolov = ((aslQarz * ((aslFoiz - (ozgaruvchiFoiz)) / aslOy)) / 100);
                    jamiFoiz += oylikFoizTolov;
                    jamiQarz += tolovFoiz;
                    ozgaruvchiFoiz += oylikFoiz;
                    kreditHisobotList.add(new KreditHisobot(String.valueOf(i), String.valueOf((numberFormat.format(tolovFoiz))), String.valueOf(numberFormat.format(oylikTolov)), String.valueOf(numberFormat.format(oylikFoizTolov))));
                }
                kreditHisobotList.add(new KreditHisobot("Jami", String.valueOf(numberFormat.format(jamiQarz)), String.valueOf(numberFormat.format(aslQarz)), String.valueOf(numberFormat.format(jamiFoiz))));
                kreditAdapter = new KreditAdapter(kreditHisobotList);
                binding.recucler1.setAdapter(kreditAdapter);
                binding.recucler1.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
            }
        });
        return binding.getRoot();
    }
}