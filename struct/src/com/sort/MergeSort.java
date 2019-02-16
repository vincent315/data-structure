package com.sort;

public class MergeSort {
    public static void mergeSort(int[] arr , int n ){
        __mergeSort(arr,0,n-1);
    }
    // 递归使用归并排序，对arr[l...r]进行排序
    public static void  __mergeSort(int[] arr,int l ,int r){
        if(l >= r)
            return;
        int mid = (l+r)/2;
        __mergeSort(arr, l, mid);
        __mergeSort(arr, mid + 1, r);
        if(arr[mid] > arr[mid+1])
            __merge(arr,l,mid,r);
    }
    //对arr[l...mid]和arr[mid+...r]两部分归并
    public static  void __merge(int[] arr,int l,int mid, int r){
        int[] aux = new int[r - l + 1];
        for(int i = l;i <= r;i++){
            aux[i - l] = arr[i];
        }
        int i = l,j = mid + 1;
        for(int k = l;k <= r;k++){
            if(i > mid){
                arr[k] = aux[j - l];
                j++;
            }else if( j >r){
                arr[k] = aux[i - l];
                i++;
            }
            else if(aux[i-l] < aux[j-l]){
                arr[k] = aux[i - l];
                i++;
            }
            else{
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,5,7,4,8,6};
        mergeSort(arr, 7);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}















