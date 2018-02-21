package com.arrays;

public class PrimitiveArrays {
    public static void main(String[] args) {
//
//
//        int[] iArr = new int[5];    //notice that an array is an object that is initialized.
//        String[] sArr = new String[5];
//        iArr[0] = 1;
//        iArr[1] = 2;
//        iArr[2] = 3;
//        iArr[3] = 4;
//        iArr[4] = 5;
//
//        for(int i=0; i<iArr.length; i++){
//            System.out.println(iArr[i]);
//        }
//        for(int i=0; i<sArr.length; i++){
//            System.out.println(sArr[i]);
//        }
        int[][] mdIArr = new int[2][5]; //array of arrays
        mdIArr[0] = new int[]{1,2,3,4};
        mdIArr[1] = new int[]{1,2,3,4,5};

        for(int i=0; i<mdIArr.length; i++){
            for(int j=0; j<mdIArr[i].length; j++){
                System.out.println(mdIArr[i][j]);
            }
        }


    }
}
