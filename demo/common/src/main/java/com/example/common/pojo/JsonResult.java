package com.example.provider.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    private Integer code;
    private String message;
    private T data;



    public JsonResult(Integer code, String message){
        this(code,message,null);
    }
}
