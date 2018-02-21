package QuestionOne;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneTest {

    @Test
    public void bubbleSort() {
        One test = new One();
        int[] subject = new int[]{4};
        String result = test.bubbleSort(subject, subject.length);
        assertEquals("[4]", result);
    }
}