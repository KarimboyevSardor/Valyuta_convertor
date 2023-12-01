// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.valyutaconvertor.convertor;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Convertor implements Parcelable {
    @SerializedName("result")
    private String result;
    @SerializedName("conversion_result")
    private double conversionResult;
    @SerializedName("time_next_update_unix")
    private long timeNextUpdateUnix;
    @SerializedName("target_code")
    private String targetCode;
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
    @SerializedName("conversion_rate")
    private double conversionRate;

    protected Convertor(Parcel in) {
        result = in.readString();
        conversionResult = in.readDouble();
        timeNextUpdateUnix = in.readLong();
        targetCode = in.readString();
        timeNextUpdateutc = in.readString();
        documentation = in.readString();
        timeLastUpdateUnix = in.readLong();
        baseCode = in.readString();
        timeLastUpdateutc = in.readString();
        termsOfUse = in.readString();
        conversionRate = in.readDouble();
    }

    public static final Creator<Convertor> CREATOR = new Creator<Convertor>() {
        @Override
        public Convertor createFromParcel(Parcel in) {
            return new Convertor(in);
        }

        @Override
        public Convertor[] newArray(int size) {
            return new Convertor[size];
        }
    };

    public String getResult() { return result; }
    public void setResult(String value) { this.result = value; }

    public double getConversionResult() { return conversionResult; }
    public void setConversionResult(double value) { this.conversionResult = value; }

    public long getTimeNextUpdateUnix() { return timeNextUpdateUnix; }
    public void setTimeNextUpdateUnix(long value) { this.timeNextUpdateUnix = value; }

    public String getTargetCode() { return targetCode; }
    public void setTargetCode(String value) { this.targetCode = value; }

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

    public double getConversionRate() { return conversionRate; }
    public void setConversionRate(double value) { this.conversionRate = value; }

    @Override
    public String toString() {
        return "Convertor{" +
                "result='" + result + '\'' +
                ", conversionResult=" + conversionResult +
                ", timeNextUpdateUnix=" + timeNextUpdateUnix +
                ", targetCode='" + targetCode + '\'' +
                ", timeNextUpdateutc='" + timeNextUpdateutc + '\'' +
                ", documentation='" + documentation + '\'' +
                ", timeLastUpdateUnix=" + timeLastUpdateUnix +
                ", baseCode='" + baseCode + '\'' +
                ", timeLastUpdateutc='" + timeLastUpdateutc + '\'' +
                ", termsOfUse='" + termsOfUse + '\'' +
                ", conversionRate=" + conversionRate +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(result);
        dest.writeDouble(conversionResult);
        dest.writeLong(timeNextUpdateUnix);
        dest.writeString(targetCode);
        dest.writeString(timeNextUpdateutc);
        dest.writeString(documentation);
        dest.writeLong(timeLastUpdateUnix);
        dest.writeString(baseCode);
        dest.writeString(timeLastUpdateutc);
        dest.writeString(termsOfUse);
        dest.writeDouble(conversionRate);
    }
}
