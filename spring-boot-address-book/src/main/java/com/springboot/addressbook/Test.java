package com.springboot.addressbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "abc", Arrays.asList("Cricket","Football", "Hockey"));
		Employee e2 = new Employee(1, "abc", Arrays.asList("Kabaddi",""));
		Employee e3 = new Employee(1, "abc", Arrays.asList("Cricket","Volleyball"));
		List<Employee> list = new ArrayList<>();
		list.add(e3);
		list.add(e1);
		list.add(e2);
		
		
		List<String> list1 = list.stream().flatMap(e -> e.getList().stream()).distinct().collect(Collectors.toList());
		
		System.out.println(list1);
		
	}

}