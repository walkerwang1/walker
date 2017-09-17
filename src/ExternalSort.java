import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class ExternalSort {
	
	static int count = 10000;     	// 文件里数据的行数
	static int number_to_sort = 1000000;     //在内存中一次排序的数量  
	static String unsort_file = "d:/bigdatasort/unsort_data.txt";     //原始未排序的文件名   
	static String sort_file = "sort_data.txt";     //已排序的文件名 
	
	public static void main(String[] args) {
		 ExternalSort externalSort = new ExternalSort();
		 externalSort.init_data(count);
		 
	}
	
	void sort() {
		Long start_time = System.currentTimeMillis();

		//将文件内容分块在内存中排序，并分别写入临时文件      
        int file_count = memory_sort();    
        //归并临时文件内容到输出文件    
        merge_sort(file_count);  
		
		Long end_time = System.currentTimeMillis();
		Long time = end_time - start_time;
	}
	
	int memory_sort() {
		int file_count = 0;		//小文件个数
		
		return file_count;
	}
	
	public void merge_sort(int file_count) {
		
	}
	
	public void init_data(int count) {
		OutputStreamWriter os;
		try {
			
			os = new OutputStreamWriter(new FileOutputStream(unsort_file), "utf-8");
			for(int i = 0; i < 1000; i++) {
				int a = Math.abs(new Random().nextInt());
				os.write(String.valueOf(a) + " ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}