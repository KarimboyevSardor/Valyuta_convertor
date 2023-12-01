package com.example.valyutaconvertor.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.valyutaconvertor.R;
import com.example.valyutaconvertor.adapters.NameAdapter;
import com.example.valyutaconvertor.convertor.Convertor;
import com.example.valyutaconvertor.databinding.FragmentMainBinding;
import com.example.valyutaconvertor.models.Models;
import com.example.valyutaconvertor.name.Name;
import com.example.valyutaconvertor.networking.ApiClient;
import com.example.valyutaconvertor.networking.ApiService;
import com.example.valyutaconvertor.valyuta.Valyuta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Main() {
    }

    public static Main newInstance(String param1, String param2) {
        Main fragment = new Main();
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
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentMainBinding binding = null;
    List name = new ArrayList<>();
    NameAdapter nameAdapter;
    List<String> names = new ArrayList<>();
    List<Double> value = new ArrayList<>();
    List<String> getNames = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        binding.calculator.setOnClickListener(v -> {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_main_to_kreditKalkulyator);
        });

        binding.convertor.setOnClickListener(v -> Navigation.findNavController(binding.getRoot()).navigate(R.id.action_main_to_valyutaConvertor));

        ApiService apiService = ApiClient.getRetrofit(requireContext()).create(ApiService.class);
        apiService.getName().enqueue(new Callback<Name>() {
            @Override
            public void onResponse(Call<Name> call, Response<Name> response) {
                if (response.isSuccessful()) {
                    getNames = new ArrayList();
                    for (int i = 0; i < response.body().getSupportedCodes().size(); i++) {
                        getNames.add(response.body().getSupportedCodes().get(i).get(1)+"%");
                    }

                    Log.d("NAME", (getNames).toString());

                }
            }
            @Override
            public void onFailure(Call<Name> call, Throwable t) {

            }
        });
        asosiy("UZS");
        binding.spinner.setText("UZS");

        binding.setBtn.setOnClickListener(v -> asosiy(binding.spinner.getText().toString()));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void asosiy(String value1) {
        ApiService apiService = ApiClient.getRetrofit(requireContext()).create(ApiService.class);
        apiService.getValyut(value1).enqueue(new Callback<Valyuta>() {
            @Override
            public void onResponse(@NonNull Call<Valyuta> call, @NonNull Response<Valyuta> response) {
                if (response.isSuccessful()) {
                    names = new ArrayList<>(response.body().getConversionRates().keySet());
                    value = new ArrayList<>(response.body().getConversionRates().values());
                    name = new ArrayList<>();
                    for (int i = 0; i < names.size(); i++) {
                        name.add(new Models(names.get(i), value.get(i), ""));
                    }
                    binding.spinner.setAdapter(new ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names));
                    nameAdapter = new  NameAdapter(name);
                    binding.recucler.setAdapter(nameAdapter);
                    binding.recucler.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
                    binding.recucler.setVisibility(View.VISIBLE);
                    binding.linearProgress.setVisibility(View.INVISIBLE);
                    binding.linear.setVisibility(View.VISIBLE);
                    binding.linear1.setVisibility(View.VISIBLE);
                    binding.linear2.setVisibility(View.VISIBLE);
                    binding.yangilanishTv.setText("Oxirgi yangilanish: "
                            + response.body().getTimeLastUpdateutc().substring(0, response.body().getTimeLastUpdateutc().length() - 5));
                    binding.yangiTv.setText("Keyingi yangilanish: " + response.body().getTimeNextUpdateutc().substring(0, response.body().getTimeNextUpdateutc().length() - 5));
                }
            }
            @Override
            public void onFailure(@NonNull Call<Valyuta> call, @NonNull Throwable t) {
            }
        });
    }

}