package com.example.valyutaconvertor.models;

public class Models {
    public String name;
    public Double value;
    public String valyuta;

    public String getValyuta() {
        return valyuta;
    }

    public void setValyuta(String valyuta) {
        this.valyuta = valyuta;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public Models(String name, Double value, String valyuta) {
        this.name = name;
        this.value = value;
        this.valyuta = valyuta;

    }
}
