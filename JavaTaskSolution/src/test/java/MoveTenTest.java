import org.junit.jupiter.api.Test;
import solutionTasks.arrayTasks.MoveTen;

import static org.testng.Assert.assertEquals;

public class MoveTenTest {


    @Test
    void sampleTests() {
        assertEquals("docdmkco", MoveTen.moveTen("testcase"));
        assertEquals("mynogkbc", MoveTen.moveTen("codewars"));
        assertEquals("ohkwzvodocdrobo", MoveTen.moveTen("exampletesthere"));
    }
}
