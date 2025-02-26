public class PascalsTriangle {
    public static int pascal(int col, int row) {
       if(col==0||row==col)
           return 1;
       return pascal(col-1,row-1)+pascal(col,row-1);
    }
    
    public static void main(String[] args) {
        System.out.println(pascal(1, 2)); // Output: 2
        System.out.println(pascal(2, 4)); // Output: 6
        System.out.println(pascal(3, 5)); // Output: 10
    }
}
