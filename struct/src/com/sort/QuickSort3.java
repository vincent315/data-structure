package com.sort;

/**
 * 3路快排处理arr[l...r]
 * 将arr[l...r]分为 <v   ==v    >v的三部分
 * 之后对大于小于两部分递归三路快排
 * */
public class QuickSort3 {
    public static void quickSort3Ways(int[] arr,int n){
        __quickSort3Ways(arr,0,n-1);
    }
    public static void __quickSort3Ways(int[] arr,int l, int r){
        if(l >= r){
            return;
        }
        int v = arr[l];
        int lt = l;//arr[l+1...lt] < v
        int gt = r+1;//arr[gt...r] > v
        int i = l+1;//arr[lt+1...i] == v
        while(i < gt){
            if(arr[i] < v){
                int temp = arr[i];
                arr[i] = arr[lt + 1];
                arr[lt+1] = temp;

                lt++;
                i++;
            }
            else if(arr[i] > v){
                int temp = arr[i];
                arr[i] = arr[gt - 1];
                arr[gt - 1] = temp;

                gt--;
            }
            else{
                i++;
            }
        }
        int temp = arr[l];
        arr[l] = arr[lt];
        arr[lt] = temp;

        __quickSort3Ways(arr,l,lt-1);
        __quickSort3Ways(arr,gt,r);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,7,4,8,6};
        quickSort3Ways(arr, arr.length);
        for(int i : arr){
            System.out.print(i + ",");
        }
    }
}
