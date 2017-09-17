
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    String[] strs = str.split(" ");
    int[] array = new int[strs.length];
    for(int i= 0; i < strs.length; i++) {
        array[i] = Integer.valueOf(strs[i]);
    }
    int x = Integer.valueOf(in.nextLine());
        */
    int[] array = {1,3,4,5,9,10,12,14,15,20};
    int x = 24;
    //System.out.println(array.length);
    int[] result = sum(array, x);
    System.out.println(result.length);
    if(result.length == 0) {
        System.out.println(-1);
    } else{
        for(int i = 0; i < result.length; i = i+2) {
        System.out.println(i + ":" + (i+1));
  	  }
    }
    
}

public static int[] sum(int[] arr, int x) {
    if(arr.length < 0) {
        return null;
    }
    int i = 0;
    int j = arr.length -1;
    int k =0;
    int m = i;
    int[] result = new int[arr.length];
    while (m < j) {
    	i = m;
        int a = arr[m];
        int b = arr[j];
        if(a + b == x) {
            result[k++] = m;
            result[k++] = j;
        }
        while(a + b > x) {
            b = arr[--j];
            if(a + b ==x) {
                result[k++] = m;
                result[k++] = j;
            }
        }
        while(a + b < x) {
            a = arr[++i];
            if(a + b ==x) {
                result[k++] = m;
                result[k++] = j;
                break;
            }
        }
        m++;
        j = arr.length -1;
    }
    return result;
}
}
