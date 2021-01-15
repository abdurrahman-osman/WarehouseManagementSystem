package com.fimba.WarehouseManagmentSystem.Response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@Setter
@Getter
public class ResponseHolder<T> {
    private T responseData;
    private HttpStatus httpStatus;
    private ResponseError error;

    public ResponseHolder(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
    public ResponseHolder(T responseData,HttpStatus httpStatus){
        this.responseData = responseData;
        this.httpStatus = httpStatus;
    }
    public ResponseHolder(HttpStatus httpStatus,ResponseError error){
        this.httpStatus = httpStatus;
        this.error = error;
    }
}
