package com.singleton.luke;

public enum Colors {
    RED("0xFF0000"),
    BLUE,
    BLACK,
    GREEN("0X00FF00"),
    PURPLE;

    private Colors(){}

    private Colors(String hexValue){
        this.hexValue = hexValue;

    }

    private String hexValue;
    public String gethexValue(){
        return hexValue;
    }
}
