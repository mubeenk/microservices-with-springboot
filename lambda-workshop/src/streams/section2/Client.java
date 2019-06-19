package streams.section2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = EmployeeSamples.getSampleEmployees().stream().
											sorted(Person::firstNameComparer).
											limit(2).
											collect(Collectors.toList());
		
		employees.forEach(System.out::println);
	
		
		
		Employee empl = EmployeeSamples.getSampleEmployees().stream().
						min((e1,e2)->	e1.getSalary() - e2.getSalary())
						.get();
		System.out.println(empl);
		
		// match
		if(EmployeeSamples.getSampleEmployees().stream().anyMatch(e->e.getSalary() > 300000))
			System.out.println("Rich guy found");
		
		long count = EmployeeSamples.getSampleEmployees().stream().filter(e->e.getSalary() > 400000).count();
		System.out.println("Found := " + count);
		
		int[] salaries = EmployeeSamples.getSampleEmployees().stream().mapToInt(Employee::getSalary).toArray();	
		for(int salary:salaries)
			System.out.println(salary);
		
		int val = EmployeeSamples.getSampleEmployees().stream().mapToInt(Employee::getSalary).reduce(Integer.MIN_VALUE, Integer::max);
		System.out.println("MAX Salary := " + val);

		int val2 = EmployeeSamples.getSampleEmployees().stream().mapToInt(Employee::getSalary).sum();
		System.out.println("Total Debt := " + val2);

		List<String> rhymes = Arrays.asList("oNe","tWo","tHree");
		String newWord = rhymes.stream().reduce("", String::concat);
		System.out.printf("new word %s \n", newWord);
		
		String newWord2 = rhymes.stream().reduce("", (s1,s2) -> s1.toUpperCase() + s2.toLowerCase());
		System.out.printf("new word %s \n", newWord2);
		
		System.out.printf("brand new word %s \n",rhymes.stream().collect(Collectors.joining("...")).toString());
	
		String newVar = String.join(",", rhymes);
		System.out.printf("brand XX word %s \n",newVar);
		
		Map<Boolean,List<Employee>> map = EmployeeSamples.getSampleEmployees().stream().collect(Collectors.partitioningBy(e->e.getSalary() > 200000));		
		map.forEach((k,v)->System.out.println(k.booleanValue() + " := " + v));
		
		System.out.println("-----------------");
		Map<Object,List<Employee>> map2 = EmployeeSamples.getSampleEmployees().stream().collect(Collectors.groupingBy(e->e.getSalary() > 200000));	
		map2.forEach((k,v)->System.out.println(k + " := " + v));
		
		Map<String, List<Emp>> empMap = EmpSamples.getSampleEmps().stream().collect(Collectors.groupingBy(Emp::getOffice));
		empMap.forEach((k,v)->System.out.println(k + " := " + v));

		// infinite stream
		Supplier rand = Math::random;
		Stream.generate(rand).limit(10).forEach(System.out::println);
	
	
	}

}
