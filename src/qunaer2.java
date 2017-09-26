import java.util.LinkedList;

public class qunaer2 {

	public static void main(String[] args) {
		LinkedListCache<String> linkedListCache = new LinkedListCache<String>(3);

        linkedListCache.put("a");
        System.out.println(linkedListCache.toString());
        linkedListCache.put("x");
        System.out.println(linkedListCache.toString());
        linkedListCache.put("d");
        System.out.println(linkedListCache.toString());
        linkedListCache.put("zzz");
        System.out.println(linkedListCache.toString());
        
        linkedListCache.get("a");
        
	}
}

class LinkedListCache<Object>{

    //默认的缓存大小
    private static int CAPACITY = 0;

    //引用一个双向链接表
    private LinkedList<Object> list;

    //构造函数
    public LinkedListCache(int capacity) {
        this.CAPACITY = capacity;
        list = new LinkedList<Object>();
    }

    //添加一个元素
    public synchronized void put(Object object) {

        if(list != null && list.contains(object)) {
            list.remove(object);
        }
        removeLeastVisitElement();
        list.addFirst(object);
    }

    //移除最近访问次数最少的元素
    private synchronized void removeLeastVisitElement() {

        int size = size();

        //注意，这儿必须得是CAPACITY - 1否则所获的size比原来大1
        if(size > (CAPACITY - 1) ) {
            Object object = list.removeLast();
//            System.out.println("本次被踢掉的元素是:" + object.toString());
        }
    }

    //获取第N个索引下面的元素
    public synchronized Object get(String key) {
    	for(Object obj : list) {
    	}
//        return list.get(index);
		return null;
    }

    //清空缓存
    public synchronized void clear() {
        list.clear();
    }

    //获取链接表的大小
    public int size() {
        if(list == null) {
            return 0;
        }
        return list.size();
    }

    //toString方法
    public String toString() {
        return list.toString();
    }

}
