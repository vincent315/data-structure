package com.sort;

public class Sort1 {

    public static void insert(int[] a){
        for(int i = 1;i < a.length; i++){
            int temp = a[i];
            int j ;
            for(j = i-1;j>=0;j--){
                if(a[j] > temp){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = temp;
        }
    }
    public static void select(int[] a){
        for(int i = 0;i < a.length;i++){
            int temp;
            for(int j = i;j<a.length;j++){
                if(a[i] > a[j]){
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
    public static void buddle(int[] a){
        for(int i = 0;i < a.length;i++){
            int temp;
            for(int j = 0;j < a.length-i-1;j++){
                if(a[j] > a[j+1]){
                     temp = a[j+1];
                     a[j+1] = a[j];
                     a[j] = temp;
                }
            }
        }
    }
    public static void test(int[] arr){
        for (int a:arr) {
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        int[] a = {3,2,5,7,4,8};
//        insert(a);
//        select(a);
        buddle(a);
        test(a);
    }
}
