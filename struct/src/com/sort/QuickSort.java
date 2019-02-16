package com.sort;

public class QuickSort {
    public static void quickSort(int[] arr,int n ){
        __quickSort(arr,0,n-1);
    }
    //对arr[l...r]进行快速排序
    public static void __quickSort(int[] arr,int l ,int r){
        if(l >= r)
            return;
        int p = __partition(arr,l,r);
        __quickSort(arr,l,p-1);
        __quickSort(arr,p+1,r);

    }
    //返回p，使得arr[l...p-1] < arr[p]  arr[p+1...r] > arr[p]
    public static int __partition(int[] arr,int l ,int r){
        int v = arr[l];
        //arr[l+1...j] < v arr[j+1...i] > v
        int j = l;
        for(int i = l+1; i <=r;i++){
            if(arr[i] < v){
                int temp = arr[j + 1];
                arr[j + 1] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 7, 4, 9, 6};
        quickSort(arr,arr.length);
        for(int  a : arr){
            System.out.print( a + ",");
        }
    }
}
