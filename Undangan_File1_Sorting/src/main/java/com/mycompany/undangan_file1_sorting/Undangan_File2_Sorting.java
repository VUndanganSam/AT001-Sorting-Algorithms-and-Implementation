/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.undangan_file1_sorting;

import java.util.ArrayDeque;

public class Undangan_File2_Sorting {
    
    public static void main(String[] args) {
        //————— List of Names —————
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
        //———————————————————

        System.out.println("Original Array:");
        printArray(names);

        // Merge Sort
        String[] mergeSortedArray = names.clone();
        mergeSort(mergeSortedArray, 0, mergeSortedArray.length - 1);
        System.out.println("\nMerge Sorted Array:");
        printArray(mergeSortedArray);

        // Quick Sort
        String[] quickSortedArray = names.clone();
        quickSort(quickSortedArray, 0, quickSortedArray.length - 1);
        System.out.println("\nQuick Sorted Array:");
        printArray(quickSortedArray);
    }

    // Merge Sort
    public static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(String[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Quick Sort
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // swap arr[i] and arr[j]
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (pivot)
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Utility method to print the array
    public static void printArray(String[] arr) {
        for (String name : arr) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}
