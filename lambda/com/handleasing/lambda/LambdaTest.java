package com.handleasing.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

public class LambdaTest {
	
	List<User> userList = null;
	
	@Before
	public void init() {
		userList = Arrays.asList(
				new User(20, "王小虎", 200),
				new User(30, "张三", 100),
				new User(15, "王小胖", 20),
				new User(22, "李四", 500),
				new User(17, "Jack", 70)
				);
	}
	
	/**
	 * 其实这个里面的 lambda 参数 e 就是 相当于接口里面的方法需要的参数
	 * e = 接口方法参数    e = User
	 * 所以 e 才能调用到 getAge() getName()  getSalary() 方法
	 */
	
	@Test
	//过滤年龄大于20岁的
	public void test1() {
		selectUser(userList,(e)->e.getAge()>20);
	}
	
	@Test
	//过滤名字包含王的
	public void test2() {
		selectUser(userList, (e)-> e.getName().indexOf("王")>=0);
	}
	
	@Test
	//过滤工资大约100的
	public void test3() {
		selectUser(userList, (e)->e.getSalary()>100);
	}
	
	
	public void selectUser(List<User> list,ISelectUser selectUser) {
		List<User> u1 = new ArrayList<User>();
		
		for (User user : list) {
			if(selectUser.test(user))
				u1.add(user);
		}
		
		for (User user : u1) {
			System.out.println(user);
		}
	}



	/**
	 * 
	 * @param str  待处理的字符串
	 * @param function 函数式接口 -> 可以理解为接受的是一个处理操作 (行为 参数化) 
	 * @return
	 */
	public String handString(String str,MyStringFunction function) {
		 return function.getValue(str);
	}
	
	@Test
	public void test4() {
		String str = "\t\t\t jackWang";
		System.out.println("source str:"+str);
		//字符串转大写
		String  str1 = handString(str, (x) -> x.toUpperCase() ); 
		System.out.println("字符串转大写:"+str1);
		//字符串截取
		String str2 = handString(str, (x) -> x.substring(10));
		System.out.println("字符串截取:"+str2);
		
		//字符串去除首尾空格
		String str3 = handString(str, (x) -> x.trim());
		System.out.println("字符串去除首尾巴空格:"+str3);
	}



}
