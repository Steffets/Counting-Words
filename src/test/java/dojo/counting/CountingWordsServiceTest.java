package dojo.counting;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingWordsServiceTest {

  private static final String DELIM1 = " ";
  private static final String DELIM2 = " |-";

  @Test
  void countWords() {
    String text = "Mary had a little lamb";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(4, countingWordsService.countWords(text).getWordCount());
  }

  @Test
  void countWords7Words() {
    String text = "Mary had a little lamb me too";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(6, countingWordsService.countWords(text).getWordCount());
  }

  @Test
  void countWordsAndUniqueWords() {
    String text = "Mary had a little lamb me too, me bla mary";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(9, countingWordsService.countWords(text).getWordCount());
    Assertions.assertEquals(8, countingWordsService.countWords(text).getUniqueWordCount());
  }


  @Test
  void countWordsAndUniqueWords2() {
    String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(7, countingWordsService.countWords(text).getWordCount());
    Assertions.assertEquals(6, countingWordsService.countWords(text).getUniqueWordCount());
  }

  @Test
  void countWordsAndUniqueWords3() {
    String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM2);
    Assertions.assertEquals(9, countingWordsService.countWords(text).getWordCount());
    Assertions.assertEquals(7, countingWordsService.countWords(text).getUniqueWordCount());
  }

  @Test
  void countWordsXtc() {
    String text = "Mary-had, a little lamb me too";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(5, countingWordsService.countWords(text).getWordCount());
  }

  @Test
  void countWordsBlank() {
    String text = "  ";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(0, countingWordsService.countWords(text).getWordCount());
  }

  @Test
  void countWordsAllForbidden() {
    String text = " the a on off the ";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(0, countingWordsService.countWords(text).getWordCount());
  }

  @Test
  void countWordsAverage() {
    String text = " ab ab cd ";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(2, countingWordsService.countWords(text).getAverage());
  }

  @Test
  void countWordsAverage2() {
    String text = " ab ab cd d";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    Assertions.assertEquals(1.75, countingWordsService.countWords(text).getAverage());
  }

  @Test
  void markKnownWords() {
    String text = "Mary had a little lamb";
    CountingWordsService countingWordsService = new CountingWordsService(DELIM1);
    List<String> known = new ArrayList<>();
    known.add("Mary*");
    known.add("had");
    known.add("little");
    known.add("lamb*");
    Assertions.assertEquals(known, countingWordsService.countWords(text).getWordsKnown());
  }

}
