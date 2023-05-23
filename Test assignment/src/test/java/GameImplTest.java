import com.assignment.nl22w.game.impl.GameImpl;
import com.assignment.nl22w.game.impl.Stringbuilder;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameImplTest {
    @Test
    void map1ShouldReturn4() throws IOException {

        Resource resource = new ClassPathResource("map1.txt");
        GameImpl game = new GameImpl();
        assertEquals(4,game.escapeFromTheWoods(resource));

    }
    @Test
    void map2ShouldReturn13() throws IOException {

        Resource resource = new ClassPathResource("map2.txt");
        GameImpl game = new GameImpl();
        assertEquals(13,game.escapeFromTheWoods(resource));

    }
    @Test
    void map5ShouldReturn0() throws IOException {

        Resource resource = new ClassPathResource("map5.txt");
        GameImpl game = new GameImpl();
        assertEquals(0,game.escapeFromTheWoods(resource));

    }
    @Test
    void map3ShouldReturn5() throws IOException {

        Resource resource = new ClassPathResource("map3.txt");
        GameImpl game = new GameImpl();
        assertEquals(5,game.escapeFromTheWoods(resource));

    }    @Test
    void map7ShouldReturn0() throws IOException {

        Resource resource = new ClassPathResource("map7.txt");
        GameImpl game = new GameImpl();
        assertEquals(0,game.escapeFromTheWoods(resource));

    }
    @Test
    void map6ShouldReturn0() throws IOException {

        Resource resource = new ClassPathResource("map6.txt");
        GameImpl game = new GameImpl();
        assertEquals(0,game.escapeFromTheWoods(resource));

    }
    @Test
    void stringLengthShouldEqualToNumOfColumns() {
        String line = "111";
        int numOfCols = 5;
        Stringbuilder stringbuilder = new Stringbuilder();
        String s = stringbuilder.padRightWhitespaces(line, numOfCols);
        int stringLength = s.length();
        assertEquals(numOfCols, stringLength);


    }
}