import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//
//        List<String> wordList= new ArrayList<>();
//        try(BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Krishna_Ahirwar\\Desktop\\Coding\\CountWordsFromFile\\src\\samplefile.txt"))))
//        {
//            String line;
//            while((line = br.readLine())!=null){
//                  System.out.println(line);
//                 String []words= line.split(" ");
//                 wordList.addAll(Arrays.asList(words));
//            }
//        }
//       catch (IOException e) {
//           System.out.println(e.getMessage());
//        }
//
//        Map<String, Long> wordsFrequency = wordList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        wordsFrequency.forEach((s, aLong) -> System.out.println(s+":"+aLong));

        Person p1= new Person("Ram","India");
        Person p2 = new Person("Ravan", "Srilanka");
        Person p3 = new Person("Bali", "Kishkindha");
        Person p4 = new Person("Laxman","India");
        Person p5 = new Person("Vibhishan","Srilanka");

        Stream.of(p1,p2,p3,p4,p5).collect(Collectors.groupingBy(Person::getCountry)).forEach((k,v)-> System.out.println(k+":"+v));
    }
}