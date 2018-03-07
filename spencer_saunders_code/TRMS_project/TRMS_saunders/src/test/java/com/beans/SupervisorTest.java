package com.beans;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import static org.junit.Assert.*;

public class SupervisorTest {

    @Test
    public void getterAndSetterCorrectness(){
        new BeanTester().testBean(Supervisor.class);
    }

}