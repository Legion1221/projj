package chapter10_Test;

import chapters.chapter_10.LAB10_C.TextProcessor;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    void testProcessText() {
        // Тестовые данные
        List<String> lines = Arrays.asList(
                "apple banana cat",
                "dog it is bat"
        );

        List<String> processedLines = TextProcessor.processText(lines);

        List<String> expected = Arrays.asList(
                "APPLE BANANA CAT",
                "DOG it is BAT"
        );


        assertEquals(expected, processedLines);
    }

    @Test
    void testEmptyInput() {

        List<String> lines = Collections.emptyList();


        List<String> processedLines = TextProcessor.processText(lines);


        List<String> expected = Collections.emptyList();


        assertEquals(expected, processedLines);
    }

    @Test
    void testSingleLineInput() {

        List<String> lines = Collections.singletonList("cat dog");

        List<String> processedLines = TextProcessor.processText(lines);

        List<String> expected = Collections.singletonList("CAT DOG");

        assertEquals(expected, processedLines);
    }
}
