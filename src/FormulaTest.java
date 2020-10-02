import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.Test;


public class FormulaTest {

    @Test
    public void Variable() {
        Variable x = new Variable("x",2.5);
        String output = x.asString();
        assertThat(output, equalTo("x"));
        double output2 = x.asValue();
        assertThat(output2, equalTo(2.5));
        x.set(5);
        output2 = x.asValue();
        assertThat(output2, equalTo(5.0));
    }
}
