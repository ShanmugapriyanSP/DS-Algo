package com.data.structures.algorithms.java.streams;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsPractice {

    public static void main(String[] args) {
//        Set 1: Beginner Level Problems
//        Sum of Integers
//        Given a list of integers, calculate the sum using streams.

        int[] numsArr = new int[]{1, 2, 3, 4, 5, 1, 1, 5, 3};

        print(Arrays.stream(numsArr).sum());

//
//        Filter Even Numbers
//        Filter out even numbers from a list of integers.

        List<Integer> nums = Arrays.stream(numsArr).boxed().collect(Collectors.toList());
        print(nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())
        );

//
//        Find Maximum
//        Find the maximum value in a list of integers using streams.
        print(nums.stream()
                .max(Integer::compareTo).get());
//
//        Square of Numbers
//        Given a list of integers, return a list of their squares.
        print(nums.stream()
                .map(a -> a * a)
                .collect(Collectors.toList()));
//
//        Sort Strings
//        Sort a list of strings in alphabetical order using streams.
        List<String> words = new ArrayList<String>() {{
            add("zebra");
            add("abby");
            add("bae");
            add("bye");
            add("cone");
            add("enoc");
            add("1234");
            add("5019");
        }};

        print(words.stream().sorted().collect(Collectors.toList()));
//
//        Count Strings with Length > 3
//        Count the number of strings in a list whose length is greater than 3.
        print(words.stream()
                .filter(a -> a.length() > 3)
                .count());

//
//        Convert Strings to Uppercase
//        Convert all strings in a list to uppercase.
        print(words.stream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList()));
//
//        Check for Any Match
//        Check if any string in a list starts with the letter "A".
        print(
                words.stream()
                        .anyMatch(a -> a.toUpperCase().startsWith("A"))
        );
//
//        Find First Match
//        Find the first string in a list that ends with the letter "e".
        print(
                words.stream()
                        .filter(a -> a.endsWith("e"))
                        .findFirst()
                        .orElse("No match found")
        );
//
//        Remove Duplicates
//        Remove duplicates from a list of integers.
        print(
                nums.stream()
                        .distinct().collect(Collectors.toList())
        );
//
//        Sum of Squares
//        Compute the sum of the squares of all numbers in a list.
        print(
                nums.stream()
                        .mapToInt(a -> a * a)
                        .sum()
        );
//
//        Collect to Map
//        Convert a list of strings into a map where the key is the string, and the value is its length.
        print(
                words.stream()
                        .collect(Collectors.toMap(a -> a, String::length))
        );
//
//        Concatenate Strings
//        Concatenate all strings in a list into a single string, separated by commas.
        print(
                words.stream()
                        .collect(Collectors.joining(","))
        );
//
//        Group Strings by Length
//        Group a list of strings by their length using Collectors.groupingBy.
        print(
                words.stream()
                        .collect(Collectors.groupingBy(String::length))
        );
//
//        Partition by Even and Odd
//        Partition a list of integers into even and odd numbers using Collectors.partitioningBy.
        print(
            nums.stream()
                    .collect(Collectors.partitioningBy(a -> a%2 ==0))

        );
//
//        Find Second Largest
//        Find the second largest number in a list of integers.
         print(
           nums.stream()
                   .sorted(Comparator.reverseOrder())
                   .skip(1)
                   .findFirst()
                   .orElseThrow(() -> new IllegalArgumentException("No second largest element"))

         );
//
//        Generate a Range of Numbers
//        Generate a list of numbers from 1 to 10 using IntStream.
        print(
          IntStream.rangeClosed(1, 10)
                  .boxed()
                  .collect(Collectors.toList())
        );
//
//        Filter Non-Empty Strings
//        Filter out empty strings from a list.
        print(
          words.stream()
                  .filter(a -> !a.isEmpty())
                  .collect(Collectors.toList())
        );
//
//        Count Vowels in Strings
//        Count the number of vowels in each string of a list.
        print(
          words.stream()
                  .collect(Collectors.toMap(a -> a, StreamsPractice::countVowels))
        );
//
//        Custom Comparator for Sorting
//        Sort a list of strings by their length using a lambda expression.
        print(
               words.stream()
                       .sorted(Comparator.comparing(String::length))
                       .collect(Collectors.toList())

        );
//
//        Find Numbers Divisible by 3
//        Filter numbers from a list that are divisible by 3.
        print(
          nums.stream()
                  .filter(a -> a %3 ==0)
                  .collect(Collectors.toList())
        );
//
//        Sum of Odd Numbers
//        Calculate the sum of odd numbers in a list.
        print(
                nums.stream()
                        .filter(a -> a%2!=0)
                        .mapToInt(Integer::intValue)
                        .sum()
        );
//
//        Skip and Limit
//        Skip the first 3 elements of a list and then limit the result to the next 5 elements.
        print(
                nums.stream()
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList())
        );
//
//        Reverse Strings
//        Reverse each string in a list using streams.
        print(
                words.stream()
                        .map(a -> new StringBuilder(a).reverse().toString())
                        .collect(Collectors.toList())
        );
//
//        Find Distinct Characters
//        Given a list of strings, find all distinct characters across all strings.
        print(
                String.join("", words)
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toSet())

        );

//        Find Kth Largest Number
//        Find the Kth largest number in a list of integers.
        int n = 3;
        print(
                nums.stream()
                        .sorted(Comparator.reverseOrder())
                        .skip(n-1)
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("KTH largest element not"))
        );
//
//        Word Frequency Count
//        Given a list of strings, count the frequency of each word.
        print(
                words.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );

//
//        Longest String
//        Find the longest string in a list. If there are multiple strings of the same length, return the first one.

        print(
          words.stream().max(Comparator.comparingInt(String::length))
                  .orElseThrow(() -> new IllegalArgumentException("longest string not found!"))
        );
//
//        Intersection of Two Lists
//        Find the intersection of two lists of integers.
        List<Integer> nums2 = new ArrayList<Integer>() {{
          add(1);
          add(8);
          add(9);
        }};
        print(
                nums.stream()
                        .filter(nums2::contains)
                        .collect(Collectors.toList())
        );
//
//        Flatten a List of Lists
//        Flatten a list of lists into a single list using streams.
        List<List<Integer>> numsListOfList = Arrays.asList(nums, nums2);
        print(
                numsListOfList.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList())
        );
//
//        Top N Elements
//        Find the top N largest elements from a list of integers.
        n = 3;

        print(
                nums.stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(n)
                        .collect(Collectors.toList())
        );
//
//        Group by First Character
//        Group a list of strings by their first character.
        print(
                words.stream()
                        .collect(Collectors.groupingBy(a -> a.substring(0, 1)))
        );
//
//        Count Palindromes
//        Count the number of palindromic strings in a list.
        Predicate<String> isPalindrome = str -> new StringBuilder(str).reverse().toString().equals(str);
        print(
                words.stream()
                        .filter(isPalindrome)
                        .count()
        );
//
//        Find Duplicates
//        Identify all duplicate elements in a list of integers.
        print(
                nums.stream()
                        .filter(a -> Collections.frequency(nums, a) > 1)
                        .collect(Collectors.toSet())
        );
//
//        Cumulative Sum
//        Create a list of cumulative sums from a list of integers (e.g., [1, 2, 3] → [1, 3, 6]).
        AtomicInteger sum = new AtomicInteger();
        print(
                nums.stream()
                        .map(sum::addAndGet)
                        .collect(Collectors.toList())
        );
//
//        Cartesian Product
//        Generate the Cartesian product of two lists.
        print(
                nums.stream()
                        .flatMap(a -> nums2.stream()
                                .map(b -> Arrays.asList(a, b)))
                        .collect(Collectors.toList())
        );

//
//        Find All Substrings
//        Given a string, generate a list of all its substrings.
        String str = "shanmugapriyan";
        print(
                IntStream.rangeClosed(0, str.length())
                        .boxed()
                        .flatMap(start -> IntStream.range(start+1, str.length())
                                .mapToObj(end -> str.substring(start, end))

                        ).collect(Collectors.toList())
        );

//
//        Filter by Custom Predicate
//        Create a reusable predicate to filter a list of strings containing only numeric values.
        Predicate<String> filterNumeric = string -> string.matches("-?\\d+");
        print(
                words.stream()
                        .filter(filterNumeric)
                        .collect(Collectors.toList())
        );
//
//        Convert Map to List
//        Convert a map (key-value pairs) into a list of strings in the format "key=value".
        Map<String, String> map = new HashMap<String, String>(){{
            put("first_key", "first_value");
            put("second_key", "second_value");
            put("third_key", "third_value");
        }};
        print(
                map.keySet().stream()
                        .map(key -> key + "=" + map.get(key))
                        .collect(Collectors.toList())
        );
//
//        Reverse Words in a Sentence
//        Reverse the words in a sentence while maintaining their order.
        String sentence = "Test sentence to reverse them while maintaining their order";
        print(
                Arrays.stream(sentence.split(" "))
                        .map(a -> new StringBuilder(a).reverse().toString())
                        .collect(Collectors.joining(" "))

        );
//
//        Custom Collector
//        Implement a custom collector to join strings in reverse order, separated by a delimiter.

//
//        Generate Prime Numbers
//        Generate the first N prime numbers using streams.
        n = 20;
        Predicate<Integer> isPrime = integer -> integer > 1 && IntStream.range(2, integer)
                .noneMatch(i -> integer % i == 0);
        print(
                IntStream.iterate(2, l -> l + 1)
                        .boxed()
                        .filter(isPrime)
                        .limit(n)
                        .collect(Collectors.toList())
        );

//
//        Longest Increasing Subsequence
//        Find the longest increasing subsequence in a list of integers.
//
//        Find Missing Numbers
//        Given a range and a list of numbers, find all missing numbers.
        n = 100;
        print(
                IntStream.rangeClosed(1, n)
                        .boxed()
                        .filter(i -> !nums.contains(i))
                        .collect(Collectors.toList())
        );
//
//        Count Word Occurrences in a Sentence
//        Count the occurrences of each word in a sentence, ignoring case.
        print(
            Arrays.stream(sentence.split(" "))
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        );
//
//        Chunk a List
//        Divide a list of integers into chunks of size N.
        n = 3;
        int finalN = n;
        print(
                IntStream.range(0, nums.size())
                        .filter(i -> i % finalN == 0)
                        .mapToObj(i -> nums.subList(i, Math.min(i + finalN, nums.size() )))
                        .collect(Collectors.toList())
        );
//
//        Zig-Zag Merge
//        Merge two lists alternately (e.g., [1, 2] and [3, 4] → [1, 3, 2, 4]).
        print(
                nums.stream()
                        .flatMap(a -> nums2.stream()
                                .flatMap(b -> Stream.of(a, b)))
                        .collect(Collectors.toList())
        );
//
//        Sort by Frequency
//        Sort a list of integers by their frequency in descending order. If two numbers have the same frequency, sort them by value.
        print(
                nums.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values()
                        .stream().sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList())
        );
//
//        Generate Fibonacci Sequence
//        Generate the first N numbers of the Fibonacci sequence using streams.
        n = 20;
        print(
                Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                        .limit(n)
                        .map(t -> t[0])
                        .collect(Collectors.toList())
        );
//
//        Custom Comparator for Complex Sorting
//        Sort a list of strings first by their length, then alphabetically.
        print(
                words.stream()
                        .sorted(Comparator.comparingInt(String::length).thenComparing(Function.identity()))
                        .collect(Collectors.toList())
        );

        // alternative
        Comparator<String> compareString = (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() > b.length() ? 1 : -1;
            }
        };
        print(
                words.stream()
                        .sorted(compareString)
                        .collect(Collectors.toList())
        );

        words.forEach(a -> System.out.println(a));

    }

    public static void print(Object obj){
        System.out.println(obj);
    }

    public static Integer countVowels(String word) {
        Integer count = 0;
        for (char a: word.toCharArray()) {
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
                count++;
        }
        return count;
    }
}
