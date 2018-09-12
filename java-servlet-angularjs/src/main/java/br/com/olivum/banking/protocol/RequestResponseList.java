package br.com.olivum.banking.protocol;

import java.util.List;

public class RequestResponseList {
    ServerResponse.Status status = ServerResponse.Status.NONE;
    String message = "";
    List<Object> data = null;

    public RequestResponseList() {
    }

    public ServerResponse.Status getStatus() {
        return status;
    }

    public void setStatus(ServerResponse.Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}