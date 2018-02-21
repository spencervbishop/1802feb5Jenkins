package com.inheritance.abstraction;

public class MountainBicycle extends Bicycle {

    //first step: implement methods

    private int numGears;
    private float gearRatio;
    private int currentGear;

    @Override
    public void go() {

    }

    @Override
    public void brake() {

    }

    public float getGearRatio() {
        return gearRatio;
    }

    public void setGearRatio(float gearRatio) {
        this.gearRatio = gearRatio;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public int getNumGears() {

        return numGears;
    }

    public void setNumGears(int numGears) {
        this.numGears = numGears;
    }
}
