package com.interfaces;

public interface Clickable {
    void onClick();

    default void log(){
        System.out.println("a click event was fired.");
    }

}
