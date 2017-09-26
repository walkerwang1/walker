import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class qunaer3 {



static class KV{
	String key;
	String value;
	
	public KV(String key,String value){
		this.key = key;
		this.value = value;
	}
}

public static void main(String[] args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
	String[] temp = br.readLine().split(" ");
	int m = Integer.parseInt(temp[0]);	//内存
	int n = Integer.parseInt(temp[1]);	//读写次数
	
	LinkedList<KV> q  = new LinkedList<KV>();
	Map<String,String> map = new HashMap<String,String>();
	//接收m条读写指令
	int qSize = 0;
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<n;i++){
		String line = br.readLine();
//		System.out.println(line);
		String[] order = line.split(" ");
		if(qSize<m && order[0].equals("put")){	//1.读入数据可放入缓存
			KV kv = new KV(order[1],order[2]);
			if (map.containsKey(order[1])) {	//map中包含键，覆盖，长度不变
				//将key为order[1]的KV对移到队列的队头
				int index = -1;
				
				q.remove(index);
				map.put(order[1], order[2]);
			}else {
				q.add(kv);	//入队
				map.put(order[1],order[2]);
				qSize ++;
			}
		}else if(qSize>=m && order[0].equals("put")){	//2.缓存区已满
			map.remove(q.poll().key);//头元素出队。（出队考虑key是否重复）
			KV kv = new KV(order[1],order[2]);
			q.add(kv);	//入队
			map.put(order[1],order[2]);
		}else if(order[0].equals("get")){	
			if(!map.containsKey(order[1]))
				sb.append("null" + "\n");
			else
				sb.append(map.get(order[1]) + "\n");
		}
	}
	System.out.println(sb.toString());
}}

