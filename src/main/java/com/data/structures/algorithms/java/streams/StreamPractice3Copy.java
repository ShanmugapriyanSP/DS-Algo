package com.data.structures.algorithms.java.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice3Copy {

    public static void main(String[] args) {

        //  Remove duplicates without distinct()
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1);
        Set<Integer> set = new HashSet<>();
        print(
                duplicateNumbers.stream()
                        .filter(set::add)
                        .toList()
        );

        // GET duplicates
        set.clear();
        print(
                duplicateNumbers.stream()
                        .filter(n -> !set.add(n))
                        .toList()
        );


        // Sort in descending order
        List<Integer> list = Arrays.asList(11, 11, 1, 3, 5, 6, 5);
        print(
                list.stream()
                        .sorted(Comparator.reverseOrder())
                        .toList()
        );

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        print(
                decimalList.stream()
                        .sorted(Comparator.reverseOrder())
                        .toList()
        );

        // Sort by length
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        print(
                listOfStrings.stream()
                        .collect(Collectors.toMap(Function.identity(), String::length))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(Map.Entry::getKey)
                        .toList()
        );

        // MAX
        List<Integer> numbers = Arrays.asList(1, 2, 4, 41, 4);
        print(
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .orElseThrow()
        );

        // Check all numbers even or not
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8, 10);
        print(
                evenNumbers.stream()
                        .allMatch(n -> n / 2 == 0)

        );

        // Check if Any String Starts with 'A'
        List<String> nameList = Arrays.asList("Banana", "Apple", "Cat", "Andrew");
        print(
                nameList.stream()
                        .filter(s -> s.startsWith("A"))
                        .toList()
        );

        // Numbers starting with 1
        List<Integer> numbers1 = Arrays.asList(10, 12, 20, null, 19, 30);
        print(
                numbers1.stream()
                        .filter(n -> n!=null && (n == 1 || (n >= 10 && n <= 19)))
                        .toList()
        );

        // Find Palindrome Strings
        List<String> palindromeNames = Arrays.asList("Telugu", "Tamil", "Malayalam");
        print(
                palindromeNames.stream()
                        .filter(s -> new StringBuilder().append(s).reverse().toString().equalsIgnoreCase(s))
                        .toList()
        );

        //  Find the longest word in a list
        print(
                palindromeNames.stream()
                        .collect(Collectors.toMap(Function.identity(), String::length))
                        .entrySet()
                        .stream()
                        .max(Comparator.comparingInt(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                        .orElseThrow()
        );

        // OR
        print(
                palindromeNames.stream()
                        .max(Comparator.comparingInt(String::length))
                        .orElseThrow()
        );
        //  perform cube on list elements and filter numbers greater than 50
        print(
                duplicateNumbers.stream()
                        .mapToDouble(n -> Math.pow(n, 3))
                        .boxed()
                        .filter(n -> n > 50)
                        .toList()
        );

        // Merge two unsorted arrays into single sorted array
        int[] a = new int[] { 4, 2, 7, 1 };
        int[] b = new int[] { 8, 3, 9, 5 };
        print(
                Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                        .sorted()
                        .toArray()
        );

        // Get top 3 elements from the list
        print(
                duplicateNumbers.stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(3)
                        .toList()
        );

        // Get 3rd highest element from the list
        print(
                duplicateNumbers.stream()
                        .sorted(Comparator.reverseOrder())
                        .skip(2)
                        .findFirst()
                        .orElseThrow()
        );

        // Check if two strings are anagrams or not
        String s1 = "RaceCar";
        String s2 = "CarRace";
        s1 = Arrays.stream(s1.toLowerCase().split("")).sorted().toString();
        s2 = Arrays.stream(s2.toLowerCase().split("")).sorted().toString();
        print(s1.equals(s2));

        //  Sum of all digits in a number
        int n = 12345;
        print(
                Arrays.stream(String.valueOf(n).split(""))
                        .collect(Collectors.summingInt(Integer::parseInt))
                        .intValue()
        );

        // Common elements between two arrays
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        print(
                list1.stream()
                        .filter(list2::contains)
                        .toList()
        );

        // Reverse each word of a string
        String str = "Java Concept Of The Day";
        print(
                Arrays.stream(str.split(" "))
                        .map(s -> new StringBuilder().append(s).reverse())
                        .collect(Collectors.joining(" "))
        );

        // Count the number of occurrences of a given String.
        List<String> strings = Arrays.asList("java scala ruby", "java react spring java");
        String word = "java";
        print(
                strings.stream()
                        .flatMap(s -> Arrays.stream(s.split(" ")))
                        .filter(word::equals)
                        .count()
        );

        // Convert the list of sentences into unique words.
        List<String> sentences = List.of("java is cool", "cool code in java");
        print(
                sentences.stream()
                        .flatMap(s -> Arrays.stream(s.split("\\s")))
                        .distinct()
                        .toList()
        );

        // You have List<List<Integer>>. How do you create a single List<Integer>?
        List<List<Integer>> nums = List.of(List.of(1, 2), List.of(3, 4));
        print(
                nums.stream()
                        .flatMap(List::stream)
                        .toList()
        );

        //  How do you get distinct characters from a list of words?
        List<String> words = List.of("java", "scala");
        print(
                words.stream()
                        .flatMap(w -> w.chars().mapToObj(c -> (char) c))
                        .distinct()
                        .toList()
        );

        // Find all the Longest words in a list
        List<String> words1 = Arrays.asList("apple", "banana", "orange", "pineapple", "blueberry");
        int max = words1.stream().max(Comparator.comparingInt(String::length)).get().length();
        print(
                words1.stream()
                        .filter(s -> s.length() == max)
                        .toList()
        );

        // Sum of numbers using reduce
        List<Integer> numbers2 = Arrays.asList(5, 10, 15, 20);
        print(
                numbers2.stream()
                        .reduce(Integer::sum)
                        .orElseThrow()
        );

        // Find Maximum using reduce
        print(
                numbers2.stream()
                        .reduce(Integer::max)
                        .orElseThrow()
        );

        //  Find the longest common prefix using Java streams:
        List<String> strings1 = Arrays.asList("flower", "flow", "flight");
        print(
                strings1.stream()
                        .reduce((x1, x2) -> {
                            int length = Math.min(x1.length(), x2.length());
                            int i = 0;
                            while (i < length && x1.charAt(i) == x2.charAt(i)) {
                                i++;
                            }
                            return x1.substring(0, i);
                        })
                        .orElseThrow()
        );

        // Max Product in a given array
        int[] array = { 1, 4, 9, 6, 2, 7, 8 };

        // First non-repeating character in a String
        String input = "aabbcdeffg";
        print(
                Arrays.stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(es -> es.getValue() == 1)
                        .findFirst()
                        .map(Map.Entry::getKey)
                        .orElseThrow()
        );

        //  Most Repeated Number in a given list.
        List<Integer> numbers3 = Arrays.asList(10, 20, 5, 8, 30, 25, 30);


        // Frequency of words or count of each word in a String
        String sentence = "Java is fun and java is powerful";


        /**
         * 1. Find students from Hyderabad with a grade greater than 8.0
         * 2. Find the student with the highest grade
         * 3. Count the number of students in each department
         * 4. Find the average grade per department
         * 5. List students sorted by age and then by grade
         * 6. Create a comma-separated list of student names
         * 7. Check if all students are above 18
         * 8. Find the department with the most students
         * 9. Divide students into those who have grades above 8.0 and below
         * 10. Find the student with the longest full name
         */
        List<Student> students = Arrays.asList(
                new Student("Rahul", "Sharma", "Hyderabad", 8.38, 19, "Civil"),
                new Student("Amit", "Verma", "Delhi", 8.4, 21, "IT"),
                new Student("Suresh", "Reddy", "Chennai", 7.5, 20, "Civil"),
                new Student("Kiran", "Patel", "Mumbai", 9.1, 20, "IT"),
                new Student("Arjun", "Naidu", "Bengaluru", 7.83, 20, "Civil"),
                new Student("Shan", "Senthil", "Chennai", 8.34, 20, "Mech")
        );

        /**
         * 1. Find the names of all Employees in the CS department, sorted by age in descending order
         * 2. Group Employees by department and count how many Employees are in each department
         * 3. Find the youngest female Employee.
         * 4. Create a map of department -> list of Employee names.
         * 5. Find the average age of Employees in each department.
         * 6. Get a list of unique departments Employees belong to
         * 7. Partition Employees into male and female groups, then list their names.
         * 8. Group employees by department, then within each department find the oldest employee
         * 9. Build a map of gender with average age of employees sorted by average age descending
         * 10. For each department, find the youngest employee, but instead of returning the employee object,
         * return only their name in uppercase.
         * 11. Return a map where keys will be first letter of the name and value will the set of names starting with
         * that letter, no solution provided, try on your own.
         */
        List<EmployeeDTO> employees = List.of(
                new EmployeeDTO("SRK","ECE",31,"Male"),
                new EmployeeDTO("Salman","CS",44,"Male"),
                new EmployeeDTO("Katrina","ECE",21,"Female"),
                new EmployeeDTO("Kareena","CS",34,"Female"),
                new EmployeeDTO("Hrithik","EEE",30,"Male"),
                new EmployeeDTO("Aish","EEE",25,"Female")
        );


        /**
         * 1. City with the second highest population
         * 2. Group by first character of name, then max population in each group
         * 3. Average population of top 3 most populated cities.
         * 4. Map of population range -> city names.
         * 5. Using reduce: String of cities ordered by population
         */

        List<City> cities = Arrays.asList(
                new City("Delhi", 12000),
                new City("Mumbai", 800000),
                new City("Bangalore", 450000),
                new City("Hyderabad", 1200000),
                new City("Chennai", 60000)
        );

        int[] arr = {10,8,0,5,3};

    }

    private static <T> void print(List<T> values) {
        values.forEach(a -> System.out.print(a + ", "));
        System.out.println();
    }

    private static <T> void print(T value) {
        System.out.println(value);
    }
}
