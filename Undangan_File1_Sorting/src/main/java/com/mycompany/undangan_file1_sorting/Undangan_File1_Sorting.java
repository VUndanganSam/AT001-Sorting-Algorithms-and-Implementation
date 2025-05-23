/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.undangan_file1_sorting;

import java.util.Arrays;


public class Undangan_File1_Sorting {

    public static void main (String[] args) {
        
        //—————————————————Lists of Names in Randomized order————————————————
        String[] names = {
            "Zoe", "Xander", "Katherine", "Isaac", "Penelope", "Jasmine",
            "Daniel", "Olivia", "Samuel", "Grace", "Lucas", "Diana",
            "Benjamin", "Emma", "Tristan", "Sarah", "Matthew", "Caleb",
            "Noah", "Vanessa", "Jacob", "William", "Leah", "Alexander",
            "Mia", "Gabriel", "Rachael", "Owen", "Joshua", "Hannah",
            "Aaron", "Yasmine", "Quentin", "Sophia", "Abigail", "Thomas",
            "Victor", "Rachel", "Kevin", "Charlotte", "Liam", "Brianna",
            "Elijah", "Zachary", "Samuel", "Patrick", "Uriel", "Alice"
        };
        //——————————————————————————————————————————————————————
        
        System.out.println("Original Array:");
        printArray(names);

        // Bubble Sort
        String[] bubbleSortedArray = names.clone();
        bubbleSort(bubbleSortedArray);
        System.out.println("\nBubble Sorted Array:");
        printArray(bubbleSortedArray);

        // Selection Sort
        String[] selectionSortedArray = names.clone();
        selectionSort(selectionSortedArray);
        System.out.println("\nSelection Sorted Array:");
        printArray(selectionSortedArray);

        // Insertion Sort
        String[] insertionSortedArray = names.clone();
        insertionSort(insertionSortedArray);
        System.out.println("\nInsertion Sorted Array:");
        printArray(insertionSortedArray);
    }

    // Bubble Sort
    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            String temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            String key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Utility method to print the array
    public static void printArray(String[] arr) {
        for (String name : arr) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}
