package com.walkerwang.algorithm.bigcompany;

import java.util.Scanner;

public class Test {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            int num = scanner.nextInt();
            for(int i=0;i<num;i++)
            {
                int n=scanner.nextInt();
                int k=scanner.nextInt();
                int[] add = new int[2*n];
                int[] arry_1 = new int[n];
                int[] arry_2 = new int[n];
                for(int j=0;j<2*n;j++)
                {
                    if(j<n)
                    {
                        arry_1[j]=scanner.nextInt();
                    }
                    else
                    {
                        arry_2[j-n]=scanner.nextInt();
                    }
                }
                add=comput1(arry_1,arry_2,k,n);
                for(int h=0;h<add.length;h++)
                {
                    if(h==add.length-1)
                        System.out.print(add[h]);
                    else
                        System.out.print(add[h]+" ");
                }
                System.out.println();
            }  
        }  
    }
    public static int[] comput1(int[] arry_1,int[] arry_2,int k,int n)
    {
        int[] add = new int[2*n];
        for(int i=0;i<k;i++)
        {
            add=comput(arry_1,arry_2,n);
            for(int j=0;j<2*n;j++)
            {
                if(j<n)
                {
                    arry_1[j]=add[j];
                }
                else
                {
                    arry_2[j-n]=add[j];
                }
            }
        }
        return add;
    }
    public static int[] comput(int[] arry_1,int[] arry_2,int n)
    {
        int[] add = new int[2*n];
        int[] add1= new int[2*n];
        int i=0;
        for(int w=n;w>0;w--)
        {
            add[i++]=arry_2[w-1];
            add[i++]=arry_1[w-1];  
        }
        for(int h=0;h<2*n;h++)
        {
            add1[2*n-h-1]=add[h];
        }
        return add1;
    }
}