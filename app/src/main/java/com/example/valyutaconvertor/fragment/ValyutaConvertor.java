package com.example.valyutaconvertor.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.valyutaconvertor.convertor.Convertor;
import com.example.valyutaconvertor.databinding.FragmentValyutaConvertorBinding;
import com.example.valyutaconvertor.networking.ApiClient;
import com.example.valyutaconvertor.networking.ApiService;
import com.example.valyutaconvertor.valyuta.Valyuta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ValyutaConvertor extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ValyutaConvertor() {
    }

    public static ValyutaConvertor newInstance(String param1, String param2) {
        ValyutaConvertor fragment = new ValyutaConvertor();
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

    FragmentValyutaConvertorBinding binding = null;
    List<String> name = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentValyutaConvertorBinding.inflate(inflater, container, false);

        ApiService apiService = ApiClient.getRetrofit(requireContext()).create(ApiService.class);

        String value = "";
        String from = "";
        String to;
        apiService.getValyut("UZS").enqueue(new Callback<Valyuta>() {
            @Override
            public void onResponse(@NonNull Call<Valyuta> call, @NonNull Response<Valyuta> response) {
                if (response.isSuccessful()) {
                    name = new ArrayList<>(response.body().getConversionRates().keySet());
                    binding.fromAut.setAdapter(new ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, name));
                    binding.toAut.setAdapter(new ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, name));
                } else {
                    Toast.makeText(requireContext(), "Failed data.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Valyuta> call, Throwable t) {
                Toast.makeText(requireContext(), "404", Toast.LENGTH_SHORT).show();
            }
        });

        binding.hisoblashBtn.setOnClickListener(v -> {
            if (binding.toAut.getText() != null && binding.fromAut.getText() != null && binding.qiymatEt.getText() != null) {
                apiService.convert(binding.fromAut.getText().toString(), binding.toAut.getText().toString(), binding.qiymatEt.getText().toString()).enqueue(new Callback<Convertor>() {
                    @Override
                    public void onResponse(Call<Convertor> call, Response<Convertor> response) {
                        if (response.isSuccessful()) {
                            binding.valueEt.setText(String.valueOf(response.body().getConversionResult()));
                        } else {
                            
                        }
                    }

                    @Override
                    public void onFailure(Call<Convertor> call, Throwable t) {
                        Toast.makeText(requireContext(), "404", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return binding.getRoot();
    }
}