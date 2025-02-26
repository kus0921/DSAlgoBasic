import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CountCharsStoredInAFile {
    public static void getCharFrequecnyFromAfile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Krishna_Ahirwar\\Desktop\\Coding\\CountWordsFromFile\\src\\samplefile.txt")));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = br.readLine()) != null) {
            content.append(line);
        }
        System.out.println(content);
        content.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }

    public static void getCharFrequecnyFromAFileWithoutStreams() throws IOException {
        FileInputStream fs = new FileInputStream(new File("C:\\Users\\Krishna_Ahirwar\\Desktop\\Coding\\CountWordsFromFile\\src\\samplefile.txt"));
        int i;
        char c;
        Map<Character, Integer> charIntMap = new HashMap<>();
        while ((i = fs.read()) != -1)
        {
            c = (char) i;
            if (charIntMap.containsKey(c)) {
                charIntMap.put(c, charIntMap.get(c) + 1);
            } else
                charIntMap.put(c, 1);
        }
        charIntMap.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        //getCharFrequecnyFromAfile();
        getCharFrequecnyFromAFileWithoutStreams();

    }
}
