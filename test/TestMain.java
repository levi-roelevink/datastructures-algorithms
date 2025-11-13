import collection.ArrayList;
import org.junit.jupiter.api.Test;

import static application.Main.twoCrystalBalls;
import static org.junit.jupiter.api.Assertions.*;

public class TestMain {
    @Test
    public void GivenSortedListOfBooleans_WhenCallingCrystalBallProblem_ExpectIndexOfFirstTrue() {
        ArrayList<Boolean> arrayList = new ArrayList<>();

        int firstBoolIndex = 19;
        for (int i = 0; i < 20; i++) {
            if (i >= firstBoolIndex) {
                arrayList.addLast(true);
            } else {
                arrayList.addLast(false);
            }
        }

        assertEquals(firstBoolIndex, twoCrystalBalls(arrayList));

        arrayList.set(firstBoolIndex, false);
        arrayList.addLast(true);
        arrayList.addLast(true);
        assertEquals(firstBoolIndex + 1, twoCrystalBalls(arrayList));

        arrayList.removeLast();
        arrayList.removeLast();
        assertEquals(-1, twoCrystalBalls(arrayList));

        arrayList.set(5, true);
        assertThrows(AssertionError.class, () -> twoCrystalBalls(arrayList));
    }
}
