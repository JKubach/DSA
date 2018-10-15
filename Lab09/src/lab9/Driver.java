package lab9;

/*
 * Purpose: Data Structure and Algorithms Lab 9 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 01/31/18
 * Submitted:  02/01/18
 * Comment: test suite and sample run attached
 * @author: John Kubach
 * @version: 2018.01.31
 */

import java.util.Scanner;

public class Driver {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int[] items;
        Driver ui = new Driver();

        items = ui.getArray();

        /* Uncomment to select sorting algorithm */

        //ui.bubbleSort(items);
        //ui.improvedBubbleSort(items);
        //ui.selectionSort(items);
        ui.improvedSelectionSort(items);
        //ui.insertionSort(items);
    }

    public void bubbleSort(int items[]) {
        System.out.println("BUBBLE SORT");
        int temp;
        int compare = 0;
        int swap = 0;
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - 1 - i; j++) {
                compare++;
                if (items[j] > items[j+1]) {
                    temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                    swap++;
                }
            }
        }
        printOperations(compare, swap);
        printArray(items);
    }

    public void improvedBubbleSort(int items[]) {
        System.out.println("\n IMPROVED BUBBLE SORT \n");
        boolean sorted = true;
        int temp;
        int compare = 0;
        int swap = 0;
        for (int i = 0; i < items.length - 1 && sorted; i++) {

            sorted = false;
            for (int j = 0; j < items.length - 1 - i; j++) {
                compare++;
                if (items[j] > items[j+1]) {
                    temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                    swap++;
                    sorted = true;
                }
            }
        }
        printOperations(compare, swap);
        printArray(items);
    }

    public void selectionSort(int[] items){
        System.out.println("\n  SELECTION SORT \n");
        int temp;
        int min;
        int swap = 0;
        int compare = 0;

        for (int i = 0; i < items.length - 1; i++) {
            min = i;
            printArray(items);
            for ( int j = (i+1); j < items.length; j++) {
                compare++;
                if (items[j] < items[min]) {
                    min = j;
                }
                printArray(items);
            }
            if (i != min){
                temp = items[i];
                items[i]=items[min];
                items[min] = temp;
                swap++;
            }
        }
        printOperations(compare, swap);
        printArray(items);
    }

    public void improvedSelectionSort(int[] items) {
        System.out.println("\n  IMPROVED SELECTION SORT \n");
        int temp;
        int min;
        int swap = 0;
        int compare = 0;
        boolean setMin = true;
        for (int i = 0; i < items.length - 1 && setMin; i++) {
            min = i;
            setMin = false;
            for ( int j = (i+1); j < items.length; j++) {
                compare++;
                if (items[j] < items[min]) {
                    min = j;
                }
            }
            if (i != min) {
                temp = items[i];
                items[i]=items[min];
                items[min] = temp;
                swap++;
                setMin = true;
            }
        }
        printOperations(compare, swap);
        printArray(items);
    }


    public void insertionSort(int items[]) {
        System.out.println("\n  INSERTION SORT \n");
        int swap = 0;
        int compare = 0;
        for (int i = 1; i < items.length; i++) {
            int j;
            int current = items[i];
            compare++;

            for (j = i - 1; j >= 0 && items[j] > current; j--) {
                items[j+1] = items[j];
                swap++;
            }
            items[j+1] = current;
        }
        printOperations(compare, swap);
        printArray(items);
    }

    public int[] getArray() {
        int size;
        int element;
        System.out.print("Enter number of integers: ");
        size = Integer.parseInt(in.nextLine());
        int newArray[] = new int[size];
        for (int i = 0; i < newArray.length; i++) {
            System.out.print("Enter integer " + (i+1) + ": ");
            element = Integer.parseInt(in.nextLine());
            newArray[i] = element;
        }
        return newArray;
    }

    public void printOperations(int compare, int swap) {
        System.out.println("Number of comparisons: " + compare);
        System.out.println("Number of swaps: " + swap);
    }

    public void printArray(int items[]) {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
