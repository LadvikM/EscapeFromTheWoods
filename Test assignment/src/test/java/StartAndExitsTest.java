import com.assignment.nl22w.game.impl.StartAndExits;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StartAndExitsTest {
    @Test
    void moreThan1000ExitsShouldReturnFalse() {
        StartAndExits startAndExits = new StartAndExits();
        List<int[]> exits = new ArrayList<>();
        for (int i = 0; i <1200; i++) {
            exits.add(new int[]{i, i});
        }
        assertFalse(startAndExits.isInLimits(exits));
    }
    @Test
    void lessThan1000ExitsShouldReturnTrue() {
        StartAndExits startAndExits = new StartAndExits();
        List<int[]> exits = new ArrayList<>();
        for (int i = 0; i <999; i++) {
            exits.add(new int[]{i, i});
        }
        assertTrue(startAndExits.isInLimits(exits));
    }
    @Test
    void zeroExitsShouldReturnFalse() {
        StartAndExits startAndExits = new StartAndExits();
        List<int[]> exits = new ArrayList<>();
        assertFalse(startAndExits.isInLimits(exits));
    }
    @Test
    void invalidRowsAndCols() {

        int numberOfRows = 1;
        int numberOfColumns = 1;
        StartAndExits startAndExits = new StartAndExits();
        boolean isInLimits = startAndExits.checkForestSize(numberOfRows, numberOfColumns);
        assertFalse(isInLimits);

    }
    @Test
    void invalidRows() {

        int numberOfRows = 1;
        int numberOfColumns = 10;
        StartAndExits startAndExits = new StartAndExits();
        boolean isInLimits = startAndExits.checkForestSize(numberOfRows, numberOfColumns);
        assertFalse(isInLimits);

    }
    @Test
    void invalidCols() {

        int numberOfRows = 10;
        int numberOfColumns = 1;
        StartAndExits startAndExits = new StartAndExits();
        boolean isInLimits = startAndExits.checkForestSize(numberOfRows, numberOfColumns);
        assertFalse(isInLimits);

    }
    @Test
    void validRowsAndCols() {

        int numberOfRows = 10;
        int numberOfColumns = 10;
        StartAndExits startAndExits = new StartAndExits();
        boolean isInLimits = startAndExits.checkForestSize(numberOfRows, numberOfColumns);
        assertTrue(isInLimits);

    }
}