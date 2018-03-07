package com.beans;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import static org.junit.Assert.*;

public class BenCoTest {

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(BenCo.class);
    }


}