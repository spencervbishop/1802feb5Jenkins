package com.inheritance.abstraction;

public abstract class Bicycle {
    protected float velocity;
    protected float height;

    public abstract void go();
    public abstract void brake(); //you can implement these at any time and your implementing classes don't need to implement it

    public float getVelocity(){
        return velocity;
    }

    public void setVelocity(float velocity){
        this.velocity = velocity;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
