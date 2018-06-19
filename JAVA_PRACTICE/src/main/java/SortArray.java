import java.util.Scanner;

public class SortArray {
    private int[] array;
    private int arraylength;
    private Scanner scanArraylength = new Scanner(System.in);
    private Scanner scanArrayValues = new Scanner(System.in);
    public void getArray(){
        System.out.println("Enter how many number of element you want to sort");
        arraylength = scanArraylength.nextInt();

        array = new int[arraylength];
        for (int i = 0; i < arraylength; i++) {
            System.out.println("Enter " + i + " th element\r");
            array[i]= scanArrayValues.nextInt();
        }
    }

    public void printArray() {
        for (int i = 0; i < arraylength; i++) {
            System.out.println("value at" + i + "th index is = "+ array[i] +"\r");
        }
    }

    public void sortArrayByOrder(boolean isAsendingOrder) {
        int tempvalue = 0;
        int tempIndex = 0;
        for(int i = 0; i < arraylength; i++) {
            tempvalue = array[i];
            tempIndex = i;
            for (int j = i+1 ; j < arraylength; j++) {
                if (isAsendingOrder) {
                    if (tempvalue > array[j]) {
                        tempvalue = array[j];
                        tempIndex = j;
                    }
                } else {
                    if (tempvalue < array[j]) {
                        tempIndex = j;
                        tempvalue = array[j];
                    }
                }
            }

            if (tempIndex != i) {
                array[tempIndex] = array[i];
                array[i] = tempvalue;
            }
        }
    }

}
