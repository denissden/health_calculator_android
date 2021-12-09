package com.example.healthcalculator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Result {
    public int Type;
    public float Value;
    public boolean IsOk;
    public String Message;
    public String  ResultDateString;

    public Result(int type, float value, boolean isOk, String message){
        Type = type;
        Value = value;
        IsOk = isOk;
        Message = message;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ResultDateString = LocalDateTime.now().format(dateFormat);
    }
}
