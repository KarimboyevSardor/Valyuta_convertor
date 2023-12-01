// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.valyutaconvertor.valyuta;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import java.util.Map;

public class Valyuta implements Serializable {
    @SerializedName("result")
    private String result;
    @SerializedName("time_next_update_unix")
    private long timeNextUpdateUnix;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;
    @SerializedName("time_next_update_utc")
    private String timeNextUpdateutc;
    @SerializedName("documentation")
    private String documentation;
    @SerializedName("time_last_update_unix")
    private long timeLastUpdateUnix;
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("time_last_update_utc")
    private String timeLastUpdateutc;
    @SerializedName("terms_of_use")
    private String termsOfUse;

    public String getResult() { return result; }
    public void setResult(String value) { this.result = value; }

    public long getTimeNextUpdateUnix() { return timeNextUpdateUnix; }
    public void setTimeNextUpdateUnix(long value) { this.timeNextUpdateUnix = value; }

    public Map<String, Double> getConversionRates() { return conversionRates; }
    public void setConversionRates(Map<String, Double> value) { this.conversionRates = value; }

    public String getTimeNextUpdateutc() { return timeNextUpdateutc; }
    public void setTimeNextUpdateutc(String value) { this.timeNextUpdateutc = value; }

    public String getDocumentation() { return documentation; }
    public void setDocumentation(String value) { this.documentation = value; }

    public long getTimeLastUpdateUnix() { return timeLastUpdateUnix; }
    public void setTimeLastUpdateUnix(long value) { this.timeLastUpdateUnix = value; }

    public String getBaseCode() { return baseCode; }
    public void setBaseCode(String value) { this.baseCode = value; }

    public String getTimeLastUpdateutc() { return timeLastUpdateutc; }
    public void setTimeLastUpdateutc(String value) { this.timeLastUpdateutc = value; }

    public String getTermsOfUse() { return termsOfUse; }
    public void setTermsOfUse(String value) { this.termsOfUse = value; }

    @Override
    public String toString() {
        return "Valyuta{" +
                "result='" + result + '\'' +
                ", timeNextUpdateUnix=" + timeNextUpdateUnix +
                ", conversionRates=" + conversionRates +
                ", timeNextUpdateutc='" + timeNextUpdateutc + '\'' +
                ", documentation='" + documentation + '\'' +
                ", timeLastUpdateUnix=" + timeLastUpdateUnix +
                ", baseCode='" + baseCode + '\'' +
                ", timeLastUpdateutc='" + timeLastUpdateutc + '\'' +
                ", termsOfUse='" + termsOfUse + '\'' +
                '}';
    }
}
