package com.controller;

import com.beans.Employee;
import com.beans.Supervisor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMethodforFun {
    public static void main(String[] args) throws Exception{


        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        System.out.println(format.format(today));
        Date date = format.parse("03/08/2018");
        long daysDiff = (date.getTime()-today.getTime())/(24*60*60*1000);
        System.out.println(daysDiff);

    }
}
