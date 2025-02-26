import java.util.*;
public class Solution 
{
  /**
   * int secondSmallest(int[] x)
   * Returns second smallest integer in array x. If x has fewer than 2 elements returns 0.
   */
  public static int sumOfSecondSmallestAndSecondLargest(int[] x)
  {
    Set<Integer> numSet = new HashSet<>();
    if(x==null || x.length<2) return 0;
    for(int i:x){
      numSet.add(i);
    }
    if(numSet.size()<2) return 0;
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;
    int secondSmallest=Integer.MAX_VALUE;

  for(int j=0;j<x.length;j++)
  {
//    if(j<smallest)
//    {
//      secondSmallest=smallest;
//      smallest = j;
//    }else if(j<secondSmallest && j!=smallest){
//      secondSmallest=j;
//    }
      if(j>largest){
          secondLargest=largest;
            largest=j;
            }
   if(j>secondLargest && j!=largest)
            {
                    secondLargest=j;
          }

  }


System.out.println("Largest "+ secondLargest+" : secondLargest :"+secondLargest);
    return secondLargest+secondSmallest;
  }

  /**
   * bool doTestsPass()
   * Runs various tests. Returns true if tests pass. Otherwise,
   * returns false.
   */
  public static boolean doTestsPass()
  {
  // todo: implement more tests, please
  // feel free to make testing more elegant
  int[] a = {0,2,3,5,1,4,5};
  int[] b = {0,1};
  int[] c = {1};
  int[] d = {6,3,3,4,5,6,7};
  int[] e = {7,7,7,7,7,7};
  
  boolean result = true; 
  result = sumOfSecondSmallestAndSecondLargest( a ) == 5;
  //result &= sumOfSecondSmallestAndSecondLargest( b ) == 1;
  //result &= sumOfSecondSmallestAndSecondLargest( c ) == 0;
  //result &= sumOfSecondSmallestAndSecondLargest( d ) == 10;
  //result &= sumOfSecondSmallestAndSecondLargest( e ) == -1;
  
  if(result)
  {
    System.out.println("All tests pass\n");
  }
  else
  {
    System.out.println("There are test failures\n");
  }
  return result;
  }

  /**
   * Execution entry point.
   */
  public static void main(String args[])
  {
  doTestsPass();
  }
}

// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!