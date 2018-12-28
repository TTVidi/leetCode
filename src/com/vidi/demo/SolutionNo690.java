package com.vidi.demo;

import java.util.HashMap;
import java.util.List;

/**
 * @Author : Vidi
 * @Date : 2018/12/27 15:49
 * @Descripton :
 * <p>
 * Employee Importance
 * <p>
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value
 * and his direct subordinates' id.
 * <p>
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance
 * value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10,
 * [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the
 * relationship is not direct.
 * <p>
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of
 * this employee and all his subordinates.
 */
public class SolutionNo690 {
	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}

	public int getImportance(List<Employee> employees, int id) {
		HashMap<Integer, Employee> em = new HashMap<>(employees.size());
		for (Employee employee : employees) {
			em.put(employee.id, employee);
		}
		return getSubordinatesImportance(em.get(id), 0, em);
	}

	public int getSubordinatesImportance(Employee employee, int result, HashMap<Integer, Employee> em) {
		result += employee.importance;
		for (Integer subordinate : employee.subordinates) {
			result = getSubordinatesImportance(em.get(subordinate), result, em);
		}
		return result;
	}

	public static void main(String[] args) {
		SolutionNo690 solution = new SolutionNo690();
		System.out.println(solution.getImportance(null, 1));
	}
}
