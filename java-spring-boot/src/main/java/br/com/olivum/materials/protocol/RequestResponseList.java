package br.com.olivum.materials.protocol;

import java.util.List;

public class RequestResponseList<T> {
    int status = ServerResponse.NONE;
    String message = "";
    List<T> data = null;

    public RequestResponseList() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}