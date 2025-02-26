package Quiz;

abstract class Reptile {
public final void layEggs() { System.out.println("Reptile laying eggs");
 }
 public static void main(String[] args) {
 Reptile reptile = new Lizard();
reptile.layEggs();
 }
 }
 public class Lizard extends Reptile {
 // public void layEggs() { System.out.println("Lizard laying eggs"); }
 }