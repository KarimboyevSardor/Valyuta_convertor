// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.example.valyutaconvertor.name;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Name implements Parcelable {
    @SerializedName("result")
    private String result;
    @SerializedName("documentation")
    private String documentation;
    @SerializedName("supported_codes")
    private List<List<String>> supportedCodes;
    @SerializedName("terms_of_use")
    private String termsOfUse;

    protected Name(Parcel in) {
        result = in.readString();
        documentation = in.readString();
        termsOfUse = in.readString();
    }

    public static final Creator<Name> CREATOR = new Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[size];
        }
    };

    public String getResult() { return result; }
    public void setResult(String value) { this.result = value; }

    public String getDocumentation() { return documentation; }
    public void setDocumentation(String value) { this.documentation = value; }

    public List<List<String>> getSupportedCodes() { return supportedCodes; }
    public void setSupportedCodes(List<List<String>> value) { this.supportedCodes = value; }

    public String getTermsOfUse() { return termsOfUse; }
    public void setTermsOfUse(String value) { this.termsOfUse = value; }

    @Override
    public String toString() {
        return "Name{" +
                "result='" + result + '\'' +
                ", documentation='" + documentation + '\'' +
                ", supportedCodes=" + supportedCodes +
                ", termsOfUse='" + termsOfUse + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(result);
        dest.writeString(documentation);
        dest.writeString(termsOfUse);
    }
}
