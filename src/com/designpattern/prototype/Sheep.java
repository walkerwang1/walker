package com.designpattern.prototype;

import java.io.Serializable;
import java.util.Date;

public class Sheep implements Cloneable, Serializable{	//1997，英国的克隆羊，多利

	private String sname;
	private Date birthday;
	
	public Sheep() {
		super();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();	//直接调用object对象的clone()方法
		
		//添加如下代码实现深拷贝（deep clone）
//		Sheep s = (Sheep)obj;
//		s.birthday = (Date)this.birthday.clone();	//把属性也进行拷贝
		
		return obj;
	}

	public Sheep(String sname, Date birthday) {
		super();
		this.sname = sname;
		this.birthday = birthday;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
