package Quiz;


import java.util.ArrayList;
import java.util.List;

public class Question_6_2 <T extends Number> {
		T t;
		public static void main(String[] args) {
			Question_6_2 q =
			   new Question_6_2<Integer>(); // 1
			q.t =  Float.valueOf(1); // 2
			System.out.println(q.t);
			q.t=Integer.valueOf(3);
			System.out.println(q.t);

			List<?> l1 = new ArrayList<>();
			List<String> l2 = new ArrayList();

			List<? super Number> list = new ArrayList<Object>(); // 1
			list.add(Integer.valueOf(2)); // 2
			//list.add(new Object()); // 3
		}
	}