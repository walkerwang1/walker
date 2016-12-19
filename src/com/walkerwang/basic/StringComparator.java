package com.walkerwang.basic;

/*
 * 如果是string+操作，我们应该尽量在一个语句中完成。如果是无法做到，并且拼接动作很多，
 * 比如数百上千成万次，则必须使用stringbuffer，不能用string+，否则速度会很慢。
 */
public class StringComparator {

	public static void main(String[] args) {
//		compare02();
		compare04();
		
	}
	
	public static void compare01() {
		/*
		 * string+比StringBuffer要快
		 * 
		 * 编译程序时，编译器会进行常量优化，
		 * 它会将a、b、c直接合成一个常量abc保存在对应的class文件当中
		 */
		String string = "a" + "b" + "c";
		
		StringBuffer sb = new StringBuffer();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		string = sb.toString();
	}
	
	static void compare02() {
		/*
		 * string+比strinbuffer快
		 * 
		 * string+其实是由stringbuilder完成的，而一般情况下stringbuilder要快于
		 * stringbuffer，这是因为stringbuilder线程不安全，少了很多线程锁的时间开销
		 */
		long time11 = System.currentTimeMillis();
		String a = "a";
		String b = "b";
		String c = "c";
		String string = a + b + c;
		long time12 = System.currentTimeMillis();
		System.out.println("1:" + (time12 - time11));
		
		long time21 = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		sb.append(a);
		sb.append(b);
		sb.append(c);
		string = sb.toString();
		long time22 =System.currentTimeMillis();
		System.out.println("2:" + (time22 - time21));
	}
	
	static void compare03() {
		/*
		 * 说是string+比stringbuffer快（但实验结果是string+慢些）
		 * 
		 * 原因：string底层是调用StringBuilder，少了线程锁的开销
		 */
		String a = "a";
	    String b = "b";
	    String c = "c";
	    long start = System.currentTimeMillis();
	    for (int i = 0; i < 100000000; i++) {
	         String string = a + b + c;
	         if (string.equals("abc")) {}
	    }
	    System.out.println("string+ cost time:" + (System.currentTimeMillis() - start) + "ms");
	    start = System.currentTimeMillis();
	    for (int i = 0; i < 100000000; i++) {
	        StringBuffer stringBuffer = new StringBuffer();
	        stringBuffer.append(a);
	        stringBuffer.append(b);
	        stringBuffer.append(c);
	        String string = stringBuffer.toString();
	        if (string.equals("abc")) {}
	    }
	    System.out.println("stringbuffer cost time:" + (System.currentTimeMillis() - start) + "ms");
	}
	
	static void compare04() {
		/*
		 * string+比stringbuffer慢得很
		 * 
		 * string+，它将会创造10万个stringbuilder对象，每一次循环体的发生，
		 * 都相当于我们新建了一个stringbuilder对象，将string对象作为构造函数的参数，
		 * 并进行一次append方法和一次toString方法。
		 */
		String a = "a";
	    long start = System.currentTimeMillis();
	    String string = a;
	    for (int i = 0; i < 100000; i++) {
	         string += a;
	    }
	    if (string.equals("abc")) {}
	    System.out.println("string+ cost time:" + (System.currentTimeMillis() - start) + "ms");
	    start = System.currentTimeMillis();
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < 100000; i++) {
	        stringBuffer.append(a);
	    }
	    if (stringBuffer.toString().equals("abc")) {}
	    System.out.println("stringbuffer cost time:" + (System.currentTimeMillis() - start) + "ms");
	  }
}
