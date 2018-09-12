package br.com.olivum.banking.protocol;

import com.google.gson.annotations.SerializedName;

public class ServerResponse {
    public static enum Status {
        @SerializedName("-1")
        NONE,
        @SerializedName("0")
        OK,
        @SerializedName("1")
        ERROR
    }
}
