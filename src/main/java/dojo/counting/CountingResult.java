package dojo.counting;

import java.util.List;

public class CountingResult {
  private int wordCount;
  private int uniqueWordCount;
  private double average;
  private List<String> wordsKnown;

  public CountingResult(List<String> wordsKnown, int wordCount, int uniqueWordCount, double average) {
    this.wordsKnown = wordsKnown;
    this.wordCount = wordCount;
    this.uniqueWordCount = uniqueWordCount;
    this.average = average;
  }

  public int getWordCount() {
    return wordCount;
  }

  public int getUniqueWordCount() {
    return uniqueWordCount;
  }

  public double getAverage() {
    return average;
  }

  public void setAverage(double average) {
    this.average = average;
  }

  public List<String> getWordsKnown() {
    return wordsKnown;
  }
}
