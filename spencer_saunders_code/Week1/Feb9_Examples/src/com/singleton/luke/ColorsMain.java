package com.singleton.luke;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ColorsMain {
    public static void main(String[] args) {
        Colors color = Colors.GREEN;

        System.out.println("color is a Colors " + Boolean.valueOf(color instanceof Colors));
        System.out.println("Colors.GREEN is a Colors " + Boolean.valueOf(Colors.GREEN instanceof Colors));

        System.out.println("The hex value of Colors.GREEN is " + color.gethexValue());
    }
}
