package chapter2.recipe04.test_getter;

import junit.framework.TestCase;
import org.junit.Test;

public class SongTest extends TestCase {

    @Test
    public void testDurationInMinutes() {
        Song song = new Song("Bicyclops", "Beck", 260);
        assertEquals(4.333333d, song.getDurationInMinutes(), 0.000001d);
    }
}
