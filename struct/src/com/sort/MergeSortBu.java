package com.sort;

public class MergeSortBu {
    public static void mergeSortBu(int[] arr,int n){
        for(int sz = 1;sz <= n;sz += sz){
            for(int i = 0; i +sz< n; i +=sz + sz){
                //对arr[i....i+sz-1]和arr[i+sz...i+2sz-1]排序
                MergeSort.__merge(arr,i,i + sz - 1,min(i + sz + sz - 1,n-1));
            }
        }
    }
    public static int min(int a,int b){
        return a > b ? b:a;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,7,4,9,6};
        mergeSortBu(arr, arr.length);
        for(int a : arr){
            System.out.print(a + ",");
        }
    }
}
