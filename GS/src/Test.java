public class Test {

	 public void print(Integer i) {
	        System.out.println("Integer");
	    }

//	    public void print(int i) {
//	        System.out.println("int");
//	    }

	    public void print(Long i) {
	        System.out.println("long");
	    }

	    public static void main(String args[]) {
	        Test test = new Test();
	        test.print(10);
	    }
	}

