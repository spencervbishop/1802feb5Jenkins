package com.inheritance.abstraction;

public class AbstractClasses {
    public static void main(String[] args) {
        Bicycle bMb = new MountainBicycle();
        MountainBicycle mb = new MountainBicycle();

        Bicycle bike = new Bicycle(){

            @Override
            public void go() {

            }

            @Override
            public void brake() {

            }
        };
    }
}
