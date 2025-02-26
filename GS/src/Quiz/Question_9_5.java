package Quiz;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface AnInterface {
		 static int aMethod() { return 0; }
		 int anotherMethod();
	//String m();
	}
	public class Question_9_5 implements AnInterface {
		 public static void main(String[] args) {
			 AnInterface a = () -> AnInterface.aMethod();
			// System.out.println(a.anotherMethod());

//			 Predicate<? super String> predicate = s -> s.startsWith("g");
//			 Stream<String> stream1 = Stream.generate(() -> "growl! ");
//			 Stream<String> stream2 = Stream.generate(() -> "growl! ");
//			 boolean b1 = stream1.anyMatch(predicate);
//			 boolean b2 = stream2.allMatch(predicate);
//			 System.out.println(b1 + " "+b2);

//			 Predicate<? super String> predicate = s -> s.length() > 3;
//			 Stream<String> stream = Stream.iterate("-", (s) -> s + s);
//			 boolean b1 = stream.noneMatch(predicate);
//			 boolean b2 = stream.anyMatch(predicate);
//			 System.out.println(b1 + " " + b2);


			 Stream<String> s = Stream.generate(() -> "meow");
			 boolean match = s.allMatch(String::isEmpty);
			 System.out.println(match);
			 IntStream is = IntStream. empty();
			//OptionalInt i =  is.findAny();
			// int i =is.sum();
			// System.out.println("Result "+i);

				//how to get output 12345
			 //(Stream.iterate(1, x -> x++).limit(5).map(x -> x).collect(Collectors.joining()));

			 //what wil be the output
//			 DoubleStream s = DoubleStream.of(1.2, 2.4);
//			 s.peek(System.out::println).filter(x -> x > 2).count();

//			 List<Integer> l1 = Arrays.asList(1, 2, 3);
//			 List<Integer> l2 = Arrays.asList(4, 5, 6);
//			 List<Integer> l3 = Arrays.asList();
//			 Stream.of(l1, l2, l3)//.map(x -> x + 1)
//					 .flatMap(x -> x.stream()).forEach(System.out::print);

			 Stream	<String> s1 = Stream.empty();
			 Stream	<String> s2 = Stream.empty();
			 Map	<Boolean, List	<String>> p = s1.collect(
					 Collectors.partitioningBy(b -> b.startsWith("c")));
			 Map<Boolean, List	<String>> g = s2.collect(
					 Collectors.groupingBy(b -> b.startsWith("c")));
			 System.out.println(p + " " + g);

			// BiFunction<Integer, Integer> f = x -> x*x;
		 }
		//AnInterface anInterface=String a, String b -> System.out.print(a+ b);
		 @Override
		 public int anotherMethod() {
			 return 1;
		 }

	} 