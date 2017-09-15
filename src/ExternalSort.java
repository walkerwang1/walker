import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class ExternalSort {
	
	static int count = 10000000;     	// 文件里数据的行数
	int number_to_sort = 1000000;     //在内存中一次排序的数量  
	String unsort_file = "unsort_data.txt";     //原始未排序的文件名   
	String sort_file = "sort_data.txt";     //已排序的文件名 
	
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
			for(int i = 0; i < count; i++) {
				os.write(new Random().nextInt());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}