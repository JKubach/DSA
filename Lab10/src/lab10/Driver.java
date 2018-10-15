package lab10;

/*
 * Purpose: Data Structure and Algorithms Lab 10 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 01/31/18
 * Submitted:  02/01/18
 * Comment: test suite and sample run attached
 * @author: John Kubach
 * @version: 2018.01.31
 */

import java.util.Scanner;
import java.util.Random;

public class Driver {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int[] items;
        int compare = 0;
        Driver ui = new Driver();

        items = ui.getArray();
        ui.printArray(items);

        /* Uncomment to select sorting algorithm */
        //ui.iterativeMergeSort(items);
        compare += ui.QuickSort( 0, items.length - 1,compare, items);
        ui.printArray(items);
        System.out.println(compare);


    }

    public void iterativeMergeSort(int items[]) {
        System.out.println("ITERATIVE MERGE SORT");
        int mid;
        int end;
        int[] tempArray = new int[items.length];
        int compare = 0;

        for (int size = 1; size < items.length; size = (size*2)) {
            for (int begin = 0; begin < items.length; begin+= (2*size)) {
                mid = (begin + size);
                end = (begin + 2 * size);
                if (end > items.length) {
                    end = items.length;
                }
                compare += mergeSubArrays(begin, end, mid, items, tempArray );
            }
        }

        printOperations(compare);
        printArray(items);
    }

    public int mergeSubArrays (int begin, int end, int mid, int items[], int tempArray[]) {
        int tempBegin = begin;
        int tempMid = mid;
        int compare = 0;
        if (mid >= items.length) {
            return 0;
        }
        /*
        System.out.println(begin);
        System.out.println(mid);
        System.out.println(end);
        */
        for (int i = begin; i < end; i++) {
            if (tempBegin == mid) {
                tempArray[i] = items[tempMid++];
            }
            else if (tempMid == end) {
                tempArray[i] = items[tempBegin++];
            }
            else if (items[tempMid] < items[tempBegin]) {
                tempArray[i] = items[tempMid++];
            }
            else {
                tempArray[i] = items[tempBegin++];
            }
            compare++;
        }
        for (int i = begin; i < end; i++) {
            items[i] = tempArray[i];
        }
        return compare;
    }



    public int QuickSort(int leftBound, int rightBound, int compare, int items[]){
        int pivot;
        if (leftBound < rightBound) {
            compare++;
            System.out.println("SORTING ARRAY" );
            printArray(items);
            System.out.println();
            pivot = quickSortPartition(leftBound, rightBound, items);
            QuickSort(leftBound, pivot - 1, compare, items);
            QuickSort(pivot + 1, rightBound, compare, items);
        }
        return compare;
    }

    public int quickSortPartition(int leftbound, int rightbound, int items[]) {
        int temp;
        int lessThan = leftbound;
        int pivot;
        System.out.println("PARTITIONING ARRAY ");
        printArray(items);
        System.out.println();
        getPivot(leftbound, rightbound, items);
        pivot = items[leftbound];
        System.out.println("COMPARING ITEMS");
        for (int greaterThan = leftbound + 1; greaterThan <= rightbound; greaterThan++) {
            if (items[greaterThan] < pivot) {
                System.out.println(items[greaterThan] + " IS LESS THAN " + pivot);
                ++lessThan;
                System.out.println("SWAP " + items[greaterThan] + " WITH " + items[lessThan]);
                temp = items[greaterThan];
                items[greaterThan] = items[lessThan];
                items[lessThan] = temp;
            }
        }
        System.out.println("SWAP PIVOT " + items[leftbound] + " WITH LAST ITEM IN <P " + items[lessThan]);
        temp = items[leftbound];
        items[leftbound] = items[lessThan];
        items[lessThan] = temp;
        System.out.println();
        return lessThan;
    }
    public void getPivot(int leftBound, int rightBound, int items[]) {
        int pivot;
        int temp;
        System.out.println("FINDING PIVOT OF ARRAY ");
        printArray(items);
        Random generatePivot = new Random();
        pivot = generatePivot.nextInt((rightBound-leftBound) + leftBound);
        System.out.println("GET PIVOT IS " + items[pivot]);
        if (leftBound <= pivot) {
            temp = items[leftBound];
            items[leftBound] = items[pivot];
            items[pivot] = temp;
        }
        printArray(items);
        System.out.println();
    }

    public int[] getArray() {
        int size;
        Random num = new Random();
        System.out.print("Enter number of integers: ");
        size = Integer.parseInt(in.nextLine());
        System.out.println("GENERATING RANDOM ARRAY...");
        int newArray[] = new int[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = num.nextInt(100);
        }
        return newArray;
    }

    public void printOperations(int compare) {
        System.out.println("Number of key comparisons: " + compare);
    }

    public void printArray(int items[]) {
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
