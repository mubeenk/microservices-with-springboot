package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DoublesTester {
	
	public static <T> void printStream(T[] arrayOfNames) {
		Stream.of(arrayOfNames).forEach(System.out::println);
	}

	public static <T> void printJustStream(IntStream stream) {
		//stream.forEach(System.out::println);
		stream.max().ifPresent(System.out::println);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double[] first = {1.0,2.0,3.0,4.0,5.0};
		
		Double[] second = Stream.of(first).map(n->n*n).toArray(Double[]::new);
		
		Stream.of(second).forEach(System.out::println);

		Double[] third = Stream.of(second).map(Math::sqrt).toArray(Double[]::new);
		
		Stream.of(third).forEach(System.out::println);

		// lookup employees
		Integer[] employeeByID = {1,3,4,8};
		
		String[] names = Stream.of(employeeByID).map(EmployeeSamples::findGoogler)
							   .map(Person::getFullName)
							   .toArray(String[]::new);
		
		printStream(names);
		
		int[] salaries = Stream.of(employeeByID).map(EmployeeSamples::findGoogler)
		   						.mapToInt(Employee::getSalary).toArray();
		
		for(int val:salaries) {
			System.out.println(val);
		}
		
		
//		Integer[] salaries2 =  Stream.of(salaries).flatMapToInt(Arrays::stream).toArray();
//		printStream(salaries2);

		Employee[] listOfEmployees = Stream.of(employeeByID).map(EmployeeSamples::findGoogler)
				   		 .filter(e-> e != null).filter(e-> e.getSalary() > 500000)
				   		 .toArray(Employee[]::new);
		printStream(listOfEmployees);
				   
		employeeByID[2]=19;
		
		for(Integer op:employeeByID) {
			System.out.print(op + ",");	
		}
		
		
		Optional<String> employeeName = Stream.of(employeeByID).map(EmployeeSamples::findGoogler)
				   .map(Person::getFullName).findFirst();
		
		System.out.println(employeeName);

		Integer[] rows = {5,2,6,8,9,1,14,18,20,21,1};
		
		List<Integer> cols = Stream.of(rows).sorted().distinct().collect(Collectors.toList());
		cols.forEach(System.out::println);
	}

}
