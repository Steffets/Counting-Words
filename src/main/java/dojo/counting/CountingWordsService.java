package dojo.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CountingWordsService {

  private String delimiter;

  public CountingWordsService(String delimiter) {
    this.delimiter = delimiter;
  }

  public CountingResult countWords(String text) {
    if (text == null) {
      return new CountingResult(null,0, 0, 0);
    }
    String[] strings = text.split(delimiter);

    List<String> words = Arrays.stream(strings)
        .filter(s -> !WordsList.FORBIDDENSTRINGS.contains(s)).collect(
            Collectors.toList());
    Set<String> wordSet = new HashSet<>();
    words.stream().forEach(s -> wordSet.add(s));
    words.stream().forEach(s -> System.out.println(s));
    double average = calculateAverage(words);
    List<String> wordsKnown = markKnownWords(words);
    return new CountingResult(wordsKnown, words.size(), wordSet.size(), average);
  }

  private List<String> markKnownWords(final List<String> words) {
    return words.stream()
        .map(s -> !WordsList.KNOWNSTRINGS.contains(s) ? s + "*" : s)
        .collect(Collectors.toList());
  }

  private double calculateAverage(List<String> words) {
    AtomicInteger count = new AtomicInteger();
    words.stream().forEach(s -> count.addAndGet(s.length()));
    return count.doubleValue() / words.size();
  }
}
