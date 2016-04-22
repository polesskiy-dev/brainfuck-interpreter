import org.junit.*;
import polesskiy.InterpreterBrainFuck;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BrainFuckTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeClass
    public static void greeting(){
        System.out.println("Now we will perform simple tests and we expecting that all of them will be passed\r\nAnd we'll get \"Invalid program string!\" message at the end");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void helloTest() throws Exception {
        final String helloStr = "+[----->+++<]>+.---.+++++++..+++.";

        InterpreterBrainFuck.main(new String[]{helloStr});
        Assert.assertEquals("hello", outContent.toString());
    }

    @Test
    public void teamdevTest() throws Exception {
        final String teamdevStr = "--------[-->+++<]>.+++[->+++<]>.----.++++++++++++.---------.+.[--->+<]>-.";

        InterpreterBrainFuck.main(new String[]{teamdevStr});
        Assert.assertEquals("teamdev", outContent.toString());
    }

    @Test
    public void nothingTest() throws Exception {
        final String str = "";

        InterpreterBrainFuck.main(new String[]{str});
        Assert.assertEquals("", outContent.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
