package com.fileio.fileio.writing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputMain {
    public static void main(String[] args) {
        ObjectOutputStream out = null;
        Person p = new Person();

        p.setName("Spencer Saunders");
        p.setAge(24);
        p.setSsn("123-45-6789");

        try{
            out = new ObjectOutputStream(new FileOutputStream("resources/person"));
            out.writeObject(p);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
