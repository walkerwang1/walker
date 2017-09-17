import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

public class BigDataSort {
	
	public static int TOTAL_NUMBER_COUNT = 1000000;
	public static int PART_NUMBER_COUNT = 100;
	
	public static String filePath = "D:/bigdatasort/unsort_data.txt";
	public static String filePath2 = "D:/bigdatasort/sort_data.txt";
	public static String dirPath = "D:/bigdatasort/smalldata/";
	
	public static void main(String[] args) throws Exception {
		
		//生成初始数据
//		initData(filePath);
		
		//将大文件分割成多个小文件，并对小文件进行快速排序
		splitBigFile2PartBySerial(filePath);
		
		//归并合并小文件
		mergeSorted(dirPath);
	}

	public static void splitBigFile2PartBySerial(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        StringBuffer buffer = new StringBuffer();
        String partPath = "D:/bigdatasort/smalldata/partfile.txt";
        
        String readerLine = "";
        int line = 0;
        while ((readerLine = reader.readLine()) != null) {
            buffer.append(readerLine + " ");
            if (++line % PART_NUMBER_COUNT == 0) {		//每次读取count行，而不是count个数据
                sortStringBuffer(buffer);
                
                int splitLine = line / PART_NUMBER_COUNT;
                String path = partPath.substring(0, partPath.indexOf(".")) + (splitLine-1) + ".txt";
                write(path, buffer.toString());
                buffer.setLength(0);
                System.out.println("SPLIT: " + splitLine);
            }
        }
        reader.close();
    }
	
	/*
	 * 向小文件中写入数据
	 */
	public static void write(String partPath, String buffer) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(partPath));
			pw.write(buffer);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 每个小文件进行快排
	 */
	public static void sortStringBuffer(StringBuffer buffer) {
        String[] numberTexts = buffer.toString().split(" ");
        buffer.setLength(0);
        int[] numbers = new int[numberTexts.length];
        for (int i = 0; i < numberTexts.length; i++) {
        	if (!numberTexts[i].equals("")) {
//        		System.out.println(numberTexts[i] + ":" + i);
        		numbers[i] = Integer.parseInt(numberTexts[i]);
			}
        }
        
        quickSort(numbers, 0, numbers.length-1);
        for (int i = 0; i < numbers.length; i++) {
            buffer.append(numbers[i] + "\n");
        }
    }
	
	/**
	 * 快速排序
	 */
	public static void quickSort(int[] arr, int left, int right){
		if(left >=right)
			return;
		int tmp = arr[left];
		int i,j;
		i = left;
		j = right;
		while(i != j){
			while(i<j && arr[j]>=tmp){  //从右到左扫描
				j--;
			}
			while(i<j && arr[i]<=tmp){	//从左到有扫描
				i++;
			}
			if(i < j){
				int t;
				t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		arr[left] = arr[i];
		arr[i] = tmp;
		
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}
	
	/*
	 * 合并几个小文件
	 */
	public static void mergeSorted(String dirPath) throws NumberFormatException, IOException {
        long t = System.currentTimeMillis();
        
        File dirFile = new File(dirPath);
        File[] partFiles = dirFile.listFiles();
        
        FileInputStream[] inputStreams = new FileInputStream[partFiles.length];
        BufferedReader[] readers = new BufferedReader[partFiles.length];
        
        int[] minNumbers = new int[partFiles.length];
        for (int i = 0; i < partFiles.length; i++) {
            inputStreams[i] = new FileInputStream(partFiles[i]);
            readers[i] = new BufferedReader(new InputStreamReader(inputStreams[i]));
            minNumbers[i] = Integer.parseInt(readers[i].readLine());
        }
        
        int numberCount = TOTAL_NUMBER_COUNT;
        StringBuilder sb = new StringBuilder();
        
        OutputStreamWriter os = null;
		try {
			
			os = new OutputStreamWriter(new FileOutputStream(filePath2), "utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
        while (true) {
            int index = minNumberIndex(minNumbers);
//            System.out.println(minNumbers[index]);
//            write(filePath2, minNumbers[index] + "\n");
            int a = sb.toString().split(" ").length;
            if (a % PART_NUMBER_COUNT == 0) {
            	//写入
				sb.append("\n");
				os.write(sb.toString());
				sb.setLength(0);
			}
            sb.append(minNumbers[index] + " ");
            String line = "";
            if ((line = readers[index].readLine()) != null) {
            	minNumbers[index] = Integer.parseInt(line);
			} else{
				minNumbers[index] = Integer.MAX_VALUE;
			}
            
            if (numberCount-- <= 1) {
                break;
            }
        }
//        write(filePath2, sb.toString());
        System.err.println("TIME: " + (System.currentTimeMillis() - t));
        
        for (int i = 0; i < partFiles.length; i++) {
            inputStreams[i].close();
            readers[i].close();
        }
    }
	
	public static int minNumberIndex(int[] minNumbers) {
		int min_value = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0; i < minNumbers.length; i++) {
			if (minNumbers[i] < min_value) {
				index = i;
				min_value = minNumbers[i];
			}
		}
		return index;
	}
	
	/*
	 * 归并排序
	 */
	public void mergeSort(int[] arr, int left, int right){
		if(left < right){
			int mid = (left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge2SortedArr(arr,left,mid,right);	// 合并两个有序的数组
		}
	}
	
	/*
	 * 合并两个有序的数组
	 */
	public void merge2SortedArr(int[] arr, int left, int mid, int right){
		int[] tmp = new int[right+1];
		int i=left, j=mid+1;
		int m=mid, n=right;
		int k =0;
		while(i<=m && j<=n){
			if(arr[i] < arr[j]){
				tmp[k++] = arr[i++];
			}else{
				tmp[k++] = arr[j++];
			}
		}
		while(i<=m){
			tmp[k++] = arr[i++];
		}
		while(j <= n){
			tmp[k++] = arr[j++];
		}
		
		//将tmp中的值全部赋值到arr中
		for(i=0;i<k; i++){
			arr[left+i] = tmp[i];	//这里的下标要注意：left+i
		}
	}
	
	/*
	 * 生成TOTAL_NUMBER_COUNT个数据
	 */
	public static void initData(String filepath) {
		
		OutputStreamWriter os;
		try {
			
			os = new OutputStreamWriter(new FileOutputStream(filepath), "utf-8");
			Random random = new Random();
			for(int i = 1; i <= TOTAL_NUMBER_COUNT; i++) {
				int a = random.nextInt(TOTAL_NUMBER_COUNT);
				if (i % PART_NUMBER_COUNT == 0) {
					//写入换行
					os.write("\n");
				}
				os.write(String.valueOf(a) + " ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
