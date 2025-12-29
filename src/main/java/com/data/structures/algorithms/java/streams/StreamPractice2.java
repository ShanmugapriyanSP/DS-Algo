package com.data.structures.algorithms.java.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice2 {


    public static void main(String[] args) {
        // Filter even numbers
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        print(
                nums.stream()
                        .filter(n -> n % 2 ==0)
                        .toList()
        );


        //Convert all strings in the list to uppercase.
        List<String> names = List.of("java", "spring", "docker");
        print(
                names.stream()
                        .map(String::toUpperCase)
                        .toList()
        );


        //Count strings starting with a specific letter
        List<String> words = List.of("apple", "banana", "avocado", "cherry");
        print(
                words.stream()
                        .filter(w -> w.startsWith("a"))
                        .count()
        );


        //Find the maximum number
        print(
                nums.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .orElseThrow()
        );


        // Remove duplicates
        List<Integer> dupNums = List.of(1, 2, 2, 3, 4, 4, 5);
        print(
                dupNums.stream()
                        .distinct()
                        .toList()
        );


        // Sum of all numbers
        print(
                nums.stream()
                        .mapToInt(Integer::intValue)
                        .sum()
        );


        // Sort strings alphabetically
        print(
                names.stream()
                        .sorted()
                        .toList()
        );

        // Check if any number is greater than 50
        List<Integer> numbers = List.of(10, 20, 60, 30);
        print(
                numbers.stream()
                        .anyMatch(n -> n > 50)
        );


        // Find first element
        print(
                numbers.stream()
                        .findFirst()
                        .orElseThrow()
        );

        //  Convert list of integers to list of strings
        print(
                numbers.stream()
                        .map(String::valueOf)
                        .toList()
        );

        //Frequency of each word
        List<String> fruits = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        print(
                fruits.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );


        // Group strings by length
        List<String> tools = List.of("Java", "Go", "Spring", "Docker");
        print(
                tools.stream()
                        .collect(Collectors.groupingBy(String::length))
        );


        // Find duplicate elements
        List<Integer> nums2 = List.of(1, 2, 3, 2, 4, 5, 1, 6);
        print(
                nums2.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .toList()
        );


        // Partition numbers into even and odd
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        print(
                numbers1.stream()
                        .collect(Collectors.partitioningBy(n -> n%2==0))
        );


        // Find the second highest number
        List<Integer> numbers2 = List.of(10, 20, 30, 40, 50);
        print(
                numbers2.stream()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .orElseThrow()
        );


        // Sort employees by salary (descending)
        List<Employee> employees = List.of(
                new Employee("shan", 1000),
                new Employee("xxx", 2200),
                new Employee("yy", 5000)
        );
        print(
                employees.stream()
                        .sorted(Comparator.comparingInt(Employee::salary).reversed())
                        .toList()
        );

        // Join strings with delimiter
        print(
                names.stream()
                        .collect(Collectors.joining(","))
        );

        // Find max value per group
        List<Employee2> employeesByDept = List.of(
                new Employee2("shan", 1000, "IT"),
                new Employee2("xxx", 2200, "IT"),
                new Employee2("yy", 5000, "MECH")
        );
        print(
                employeesByDept.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::department,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Employee2::salary)),
                                        e -> e.get().salary()
                                )
                        ))
        );

        // Flatten list of lists
        List<List<Integer>> list = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5)
        );
        print(
                list.stream()
                        .flatMap(List::stream)
                        .toList()
        );

        // Check if all numbers are positive
        List<Integer> numbers3 = List.of(1, 3, 5, 7);
        print(
                numbers3.stream()
                        .allMatch(n -> n > 0)
        );


        // Top N frequent elements
        List<Integer> numbers4 = List.of(1,1,1,2,2,3,3,3,3,4,5,5);
        int n = 3;
        print(
                numbers4.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                        .limit(n)
                        .map(Map.Entry::getKey)
                        .toList()
        );


        // Group employees by department and sort by salary
        List<Employee2> employeesByDept2 = List.of(
                new Employee2("shan", 1000, "IT"),
                new Employee2("xxx", 2200, "IT"),
                new Employee2("yyy", 5000, "MECH"),
                new Employee2("zzz", 1000, "MECH")
        );
        print(
                employeesByDept2.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::department,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        ls -> ls.stream()
                                                .sorted(Comparator.comparingInt(Employee2::salary).reversed())
                                                .toList()
                                )
                        ))

        );

        // Longest string per group
        List<String> words2 = List.of("apple", "ape", "banana", "bat", "ball");
        print(
                words2.stream()
                        .collect(Collectors.groupingBy(
                                w -> w.charAt(0),
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(String::length)),
                                        Optional::get
                                )
                        ))

        );


        // Custom Collector (Average excluding min & max)
        // Calculate the average salary, excluding the minimum and maximum salary, using a custom collector.
        print(
                employeesByDept2.stream()
                        .collect(
                                Collector.of(
                                        () -> new ArrayList<Integer>(),
                                        (ls2, element) -> ls2.add(element.salary()),
                                        (l1, l2) -> {l1.addAll(l2); return l1;},
                                        ls1 -> ls1.stream()
                                                .sorted(Comparator.reverseOrder())
                                                .skip(1)
                                                .limit(ls1.size() - 2)
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElseThrow()

                                )
                        ).longValue()
        );


        // Merge two lists and remove duplicates while preserving order
        List<Integer> a = List.of(1,2,3,4);
        List<Integer> b = List.of(3,4,5,6);
        print(
                Stream.concat(a.stream(), b.stream()).distinct().toList()
        );

        // Find first non-repeating character
        print(
                "aaaaabc".chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElseThrow()
        );

        // Nested grouping
        // Group employees by department, then by salary range
        print(
                employeesByDept2.stream()
                        .collect(Collectors.groupingBy(
                                Employee2::department,
                                Collectors.groupingBy(e -> {
                                    if (e.salary() < 3000) return "<3000";
                                    if (e.salary() <= 6000) return "3000-6000";
                                    return ">6000";
                                })
                        ))
        );

        // Parallel stream safety problem

        // numbers.parallelStream().forEach(result::add);
        // ArrayList is not thread-safe
        //Leads to race conditions
        //Order is not guaranteed
        // Corrected version:
        numbers.parallelStream().collect(Collectors.toList());

    }

    private static <T> void print(List<T> values) {
        values.forEach(a -> System.out.print(a + ", "));
        System.out.println();
    }

    private static <T> void print(T value) {
        System.out.println(value);
    }

}

record Employee(String name, int salary){}

record Employee2(String name, int salary, String department) {}