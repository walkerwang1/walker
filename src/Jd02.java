import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Jd02 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*while (in.hasNextLine()) {//注意while处理多个case
            String str = in.nextLine();
            
        }*/
        
        Object[] arr = {3, 0, 2, 2};
        
        Arrays.sort(arr);
        
        
        Set set = new HashSet();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        //返回Set集合的数组形式
        arr = set.toArray();
        
        int count = 0;
        
        int length = arr.length;
        
        for(int k = 1; k <= (length * (length + 1)) / 2; k++) {
        	for(int i = 0; i < length; i++) {
        		int value1= (int) arr[i];
        		for(int j= i; j < length; j++) {
        			int value2 = (int) arr[j];
        			int result = compXor(i, j, value1, value2, arr);
        			if (result == 0) {
						count++;
					}
        		}
        	}
        }
        
        
        System.out.println(count);
    }
	
	public static int compXor(int i, int j, int value1, int value2, Object[] arr){
		
		int result = -1;
		while(i <= j) {
			if (i ==j) {
				result = (int)arr[i] ^ (int)arr[j];
				break;
			} else {
				result = (int)arr[i] ^ (int)arr[++i];
			}
		}
		return result;
	}
}
