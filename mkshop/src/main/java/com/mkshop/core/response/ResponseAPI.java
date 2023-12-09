package com.mkshop.core.response;

import com.mkshop.mkshop.data.infrastructure.model.Category;
import org.springframework.http.HttpStatus;

import java.util.List;


public class ResponseAPI<T> {
    private T data;
    private int statusCode;
    private String error;
    private boolean hasError;

    public ResponseAPI(List<Category> all, boolean hasError, HttpStatus ok, Object error) {
    }

    public ResponseAPI(T data, boolean hasError, int statusCode, String error) {
        this.data = data;
        this.hasError = hasError;
        this.statusCode = statusCode;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
