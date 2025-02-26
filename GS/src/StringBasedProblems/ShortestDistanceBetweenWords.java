package StringBasedProblems;

import java.util.*;

public class ShortestDistanceBetweenWords {
    public static double shortestDistance(String document, String word1, String word2)
    {
        // Split the document into words and track character indices
        String[] words = document.split(" ");
        ArrayList<Double> positionWord1 = new ArrayList<>();
        ArrayList<Double> positionWord2 = new ArrayList<>();
        double shortestDistance = Double.MAX_VALUE;
        int currentIndex = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(word1)) {
                positionWord1.add((currentIndex + word.length()/2d));
            }
            if (word.equalsIgnoreCase(word2)) {
                positionWord2.add( (currentIndex + word.length()/2d));
            }
            currentIndex = currentIndex + word.length() + 1;
        }

        for (double i : positionWord1) {
            for (double j : positionWord2) {
                shortestDistance = Math.min(shortestDistance, Math.abs(i - j));
            }

        }

        return shortestDistance;
    }

    public static void main(String[] args) {
        String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements.";

        System.out.println(shortestDistance(document, "is", "a"));


    }

}


//String[] words = document.split("\\s+");
//        List<Integer> positionsWord1 = new ArrayList<>();
//        List<Integer> positionsWord2 = new ArrayList<>();
//
//        int currentIndex = 0;
//        for (String word : words) {
//            if (word.equalsIgnoreCase(word1)) {
//                positionsWord1.add(currentIndex + word.length() / 2);
//            }
//            if (word.equalsIgnoreCase(word2)) {
//                positionsWord2.add(currentIndex + word.length() / 2);
//            }
//            currentIndex += word.length() + 1; // Add 1 for the space character
//        }
//
//        // Find the shortest distance between midpoints of the words
//        double shortestDistance = Double.MAX_VALUE;
//        for (int pos1 : positionsWord1) {
//            for (int pos2 : positionsWord2) {
//                shortestDistance = Math.min(shortestDistance, Math.abs(pos1 - pos2));
//            }
//        }