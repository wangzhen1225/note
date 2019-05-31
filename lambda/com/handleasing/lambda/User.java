package com.handleasing.lambda;

public class User {
	private Integer age;
	private String name;
	private Integer salary;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
	
	public User() {
		super();
	}
	public User(Integer age, String name, Integer salary) {
		super();
		this.age = age;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
