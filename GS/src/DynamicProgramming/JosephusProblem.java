package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

/*
A group of students are sitting in a circle. The teacher is electing a new class president.
The teacher does this by singing a song while walking around the circle. After the song is finished the student at which the teacher stopped is removed from the circle.
Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
after the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first student to go would be “2°, after that “4°, and after that ~3>. Student ~1° would be the next president in this example.

Signature:

public static int whoIsElected(int n, int k) {
}

Test Cases:
Input : 1, 1
Output :1

Input : 2, 2
Output :1

Input : 4, 2
Output :1

 */
public class JosephusProblem {
    public static int findPresident(int n, int k) {
        List<Integer> students = new LinkedList<>();
        
        // Initialize the students list
        for (int i = 1; i <= n; i++) {
            students.add(i);
        }
        
        int index = 0; // Start at the first student
        
        // Eliminate students until one remains
        while(students.size()>1)
        {
             index = (index + k-1)%students.size();
             students.remove(index);
        }
        return students.get(0); // The last remaining student is the president
    }
    
    public static void main(String[] args) {
        int n = 4; // Number of students
        int k = 2; // Length of the song
        
        int president = findPresident(n, k);
        System.out.println("The new class president is student: " + president);
    }
}
