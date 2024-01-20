package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question1 {
	public static void main(String[] args) {
		
//	qouestion1
//	List<Integer> list = new ArrayList<Integer>(); // new ArrayList<Number>();
//
//	list.add(30); // new Integer(30);
//	list.add(10);
//	list.add(20);
//	list.add(40);
//	list.add(20);
//	list.add(50);
//	list.add(10);
//	System.out.println(list.stream().distinct().collect(Collectors.toList()));
//	
//	}
//	qouestion2
//	List<Integer> list = new ArrayList<Integer>(); // new ArrayList<Number>();
//
//	list.add(30); // new Integer(30);
//	list.add(10);
//	list.add(20);
//	list.add(40);
//	list.add(20);
//	list.add(50);
//	list.add(10);
//	
//	System.out.println(sum(list));
//	
//}
//	public static int sum(List<Integer> list) {
//		int c=list.stream().mapToInt(Integer::intValue).sum();
//		return c;
//		
//	}
//}
//qouestion04

		        List<String> list = new ArrayList<>();

		        list.add("krishnakanr");
		        list.add("bmanam");
		        list.add("orange");
		        list.add("papaya");
		        list.add("dfghjkl");

		        System.out.println(findLength(list));
		    }

		    public static List<String> findLength(List<String> list) {
		        return list.stream()
		                .filter(s -> s.length() > 5)
		                .collect(Collectors.toList());
		    }
		}

// differant way 


//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ListTasks {
//    public static void main(String[] args) {
//        // create a list of integers
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(30);
//        list.add(10);
//        list.add(20);
//        list.add(40);
//        list.add(20);
//        list.add(50);
//        list.add(10);
//
//        // Task 1: Convert the list to an array
//        Integer[] array = list.toArray(new Integer[0]);
//
//        // Print the elements of the array
//        System.out.println("Array elements:");
//        for (Integer element : array) {
//            System.out.print(element + " ");
//        }
//        System.out.println(); // newline for better readability
//
//        // Task 2: Get the sum of all numbers present in the list
//        int sum = Arrays.stream(array).mapToInt(Integer::intValue).sum();
//        System.out.println("Sum of numbers: " + sum);
//
//        // Task 3: Perform cube on list elements and filter numbers greater than 50
//        List<Integer> cubeAndFiltered = Arrays.stream(array)
//                .map(n -> n * n * n)
//                .filter(n -> n > 50)
//                .toList();
//
//        System.out.println("Cube of numbers greater than 50: " + cubeAndFiltered);
//
//        // Task 4: Print strings whose length is greater than 5 in a list
//        List<String> strings = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");
//        strings.stream()
//                .filter(s -> s.length() > 5)
//                .forEach(System.out::println);
//
//        // Task 5: Count strings whose length is greater than 5 in a list
//        long count = strings.stream()
//                .filter(s -> s.length() > 5)
//                .count();
//
//        System.out.println("Number of strings with length greater than 5: " + count);
//    }
//}
