package br.com.olivum.banking.protocol;

public class RequestResponse {
    ServerResponse.Status status = ServerResponse.Status.NONE;
    String message = "";
    Object data = null;

    public RequestResponse() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}