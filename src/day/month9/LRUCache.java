package day.month9;

import java.util.HashMap;

/*
 * LRU Cache的链表+HashMap实现
 * http://www.cnblogs.com/lzrabbit/p/3734850.html#f2
 */
public class LRUCache<K, V> {
	
	private final int MAX_CACHE_SIZE;
	private Entry first;
	private Entry last;
	
	//这个位置为什么要用Entry<K,V>
	private HashMap<K, Entry<K, V>> hashMap;
	
	public LRUCache(int cacheSize) {
		MAX_CACHE_SIZE = cacheSize;
		hashMap = new HashMap<>();
	}
	
	/*
	 * 向map中添加元素
	 */
	public void put(K key, V value) {
		Entry<K, V> entry = getEntry(key);
		if (entry == null) {	//map中不存在该元素
			if (hashMap.size() >= MAX_CACHE_SIZE) {
				hashMap.remove(last.key);
				removeLast();
			}
			entry = new Entry<>();
			entry.key = key;
		}
		entry.value = value;	//key已存在，只需要更新值即可
		moveToFirst(entry);		//如果entry在链表中存在，则移到链表最前面
		hashMap.put(key, entry);
	}
	
	/*
	 * 按key值获取某个元素。访问该key后需要更新其位置
	 */
	public V get(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry == null) {
			return null;
		}
		moveToFirst(entry);
		return entry.value;
	}
	
	/*
	 * 移除某个元素
	 */
	@SuppressWarnings("unchecked")
	public void remove(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry != null) {
			if (entry.pre != null)
				entry.pre.next = entry.next;
			if (entry.next != null) 
				entry.next.pre = entry.pre;
			if (entry == first)
				first = entry.next;
			if (entry == last) 
				last = entry.pre;
		}
		hashMap.remove(key);
	}
	
	/*
	 * 将entry移到头部
	 * (first->...->last)
	 */
	@SuppressWarnings("unchecked")
	public void moveToFirst(Entry<K, V> entry) {
		if (entry == first) 
			return;
		if (entry.pre != null)
			entry.pre.next = entry.next;
		if (entry.next != null) 
			entry.next.pre = entry.pre;
		if (entry == last)	//如果是last元素，last指针需要向前移动一次
			last = last.pre;
		if (first == null || last == null) {
			first = last = entry;
			return;
		}
	
		//前面的步骤是将entry从链表中脱离，下面实施真正的插入到first位置
		entry.next = first;
		first.pre = entry;
		first = entry;
		entry.pre = null;
	}
	
	/*
	 * 如果cache超过容量，则移除链表中最后一个元素
	 */
	private void removeLast() {
		if (last != null) {
			last = last.pre;
			//判断last前面是否有元素
			if (last == null) 
				first = null;
			else
				last.next = null;
		}
	}
	
	/*
	 * 判断map中是否存在key对应的Entry
	 */
	public Entry<K, V> getEntry(K key) {
		return hashMap.get(key);
	}
	
	/*
	 * 输出，重写toString()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Entry<K, V> entry = first;
		while (entry != null) {
			sb.append(String.format("%s:%s ", entry.key, entry.value));
			entry = entry.next;
		}
		return sb.toString();
	}
	
	
	class Entry<K, V> {
		public Entry<K, V> pre;
		public Entry<K, V> next;
		public K key;
		public V value;
	}
	
	public static void main(String[] args) {
		System.out.println("--------------LRU 链表+HashMap实现-----");
		LRUCache<Integer, String> lru = new LRUCache<>(5);
		lru.put(1, "11");
        lru.put(2, "22");
        lru.put(3, "33");
        lru.put(4, "44");
        lru.put(5, "55");
        System.out.println(lru.toString());
        lru.put(6, "66");
        System.out.println(lru.toString());
        lru.get(2);
        System.out.println(lru.toString());
        lru.put(7, "77");
        System.out.println(lru.toString());
        lru.get(4);
        System.out.println(lru.toString());
	}
}
