package com.handleasing.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 使用 jdk 8 自带的四大函数式接口
 * @author jackwang
 *
 */
public class FunctionInterfaceJDKTest {
	
	
	/**
	 * 1.Consumer<T>：消费型接口 
	 * 		void accept(T t);   
	 * 2.Supplier<T>：供给型接口 
	 * 		T get();
	 * 3.Function<T, R>：函数型接口 
	 * 		R apply(T t);
	 * 4.Predicate<T>：断言型接口
	 * 		boolean test(T t);
	 */
	
	 public void Shopping(Double money,Consumer<Double> consumer) {
		consumer.accept(money);
	 }
	 
	 @Test
	//消费性
	 public void testConsume() {
		 Shopping(100D, (e) -> {
			 System.out.println("消费性接口");
			 System.out.println("购物消费了"+e+"元");
		 });
	 }
	 
	 /**
	  * 产生指定个数的数字放入集合中
	  * @param supplier
	  * @return
	  */
	 public List<Integer> getList(Integer num, Supplier<Integer> supplier) {
		 List<Integer> list = new ArrayList<Integer>();
		 for (int i = 0; i < num; i++) {
		   list.add(supplier.get())	;
		 }
		 return list;
	 }
	
	 @Test
	 //供给性质
	 public void testSupplier() {
		 List<Integer> list = getList(5, () -> (int)(Math.random()*100));
		 
		 for (Integer integer : list) {
			System.out.println(integer);
		 }
	 }
	 
	 
	 public void handleString(String string,Function<String, String> function) {
		String str = function.apply(string);
		System.out.println(str);
	 }
	 
	 @Test
	 //函数性的接口
	 public void testFunction() {
		 //转大写
		 handleString("JackWang", (e) -> e.toUpperCase());
		 
		 //截取字符串
		 handleString("JackWang", (e) -> e.substring(2));
	 }
	 
	 
	 
	 public void filterList(List<String> list,Predicate<String> predicate) {
		 for (String string : list) {
			if (predicate.test(string)) {
				System.out.println(string);
			}
		}
	 }
	 
	 
	 @Test
	 //断言性接口
	 public void testPredicate() {
		 List<String> list = Arrays.asList("jack","wang","JackWang","zhang","san");
		 
		 filterList(list, (e) -> e.length()>4);
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
