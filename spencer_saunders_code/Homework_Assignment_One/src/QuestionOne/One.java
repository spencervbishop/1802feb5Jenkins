package QuestionOne;

public class One {

    public static void main(String[] args){
        int[] intArray = new int[]{1,0,5,6,3,2,3,7,9,8,4};

          bubbleSort(intArray, intArray.length);

        for(int i=0; i<11; i++){
            System.out.println(intArray[i]);
        }
    }
    static void bubbleSort(int[] a, int n){
        for(int i=0; i<=n-1;i++){
            for(int j=0; j<n-i-1; j++) {
                if (a[j] > a[j + 1]) {
                    int x = a[j];
                    a[j] = a[j + 1];
                    a[j+1] = x;
                }
            }
        }
    }
}
