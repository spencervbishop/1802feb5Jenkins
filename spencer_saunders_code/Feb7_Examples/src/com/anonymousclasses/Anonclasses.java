package com.anonymousclasses;

public class Anonclasses {

    public static void main(String[] args) {
        Button b = new Button();
        ClickEvent e = new ClickEvent() {
            public void doEvent(){
                System.out.println("click event was triggered.");
            }
        };

        b.subscribe(e);
        b.onClick();
    }
}
