package com.example.valyutaconvertor.models;

public class KreditHisobot {
    private String son;
    private String tolov;
    private String asosiyQarz;
    private String foiz;

    public KreditHisobot(String son, String tolov, String asosiyQarz, String foiz) {
        this.son = son;
        this.tolov = tolov;
        this.asosiyQarz = asosiyQarz;
        this.foiz = foiz;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }


    public String getTolov() {
        return tolov;
    }

    public void setTolov(String tolov) {
        this.tolov = tolov;
    }

    public String getAsosiyQarz() {
        return asosiyQarz;
    }

    public void setAsosiyQarz(String asosiyQarz) {
        this.asosiyQarz = asosiyQarz;
    }

    public String getFoiz() {
        return foiz;
    }

    public void setFoiz(String foiz) {
        this.foiz = foiz;
    }
}
