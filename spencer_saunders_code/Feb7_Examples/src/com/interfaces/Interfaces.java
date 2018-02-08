package com.interfaces;

public class Interfaces {
    public static void main(String[] args) {
        Button b = new Button();
//        ClickEvent ce = new LeftMouseClick();
//        b.subscribe(ce);
//
//        b.onClick();
        b.subscribe(() -> {
            System.out.println("Lambda function fired");
        });
        b.onClick();

    }
}
