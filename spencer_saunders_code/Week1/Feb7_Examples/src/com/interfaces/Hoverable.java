package com.interfaces;

public interface Hoverable {
    void onHover();

    default void log(){
        System.out.println("A hoverable event was fired.");
    }
}
