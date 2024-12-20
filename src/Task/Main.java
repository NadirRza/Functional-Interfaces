package Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello","world","java");
        Consumer<String> toUpperCaseConsumer= word -> System.out.println(word.toUpperCase());
        words.forEach(toUpperCaseConsumer);

        Supplier<String> dateTime = () ->{
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm (EEEE) -dd MMM yyyy");
            return now.format(formatter);
        };
        System.out.println(dateTime.get());

        Function<String,Integer> wordLength = word->word.length();
        List<Integer> wordLengths=words.stream()
                .map(wordLength)
                .collect(Collectors.toList());
        System.out.println(wordLengths);
    }
}
