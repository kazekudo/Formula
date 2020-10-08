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


    @Test
    public void Product() {
        Variable x = new Variable("x",2.5);
        Variable y = new Variable("y",4.0);
        Formula formula = new Product(x,y);
        double output = formula.asValue();
        assertThat(output, equalTo(10.0));

        String output2 = formula.asString();
        assertThat(output2, equalTo("(x*y)"));
    }

    @Test
    public void Sum() {
        Variable x = new Variable("x",2.5);
        Variable y = new Variable("y",4.0);
        Formula formula = new Sum(x,y);
        double output = formula.asValue();
        assertThat(output, equalTo(6.5));

        String output2 = formula.asString();
        assertThat(output2, equalTo("(x+y)"));

        formula = new Sum(x,x,y,y);
        output = formula.asValue();
        assertThat(output, equalTo(13.0));

        output2 = formula.asString();
        assertThat(output2, equalTo("(x+x+y+y)"));

        formula = new Sum(x, new Product(y, new Sum(x, y)));
        output = formula.asValue();
        assertThat(output, equalTo(28.5));
    }

    @Test
    public void AbsoluteValue(){
        Variable x = new Variable("x",-2.5);
        Variable y = new Variable("y",-1.0);

        Formula formula = new AbsoluteValue(new Sum(x, y));
        double output = formula.asValue();
        assertThat(output, equalTo(3.5));

        String output2 = formula.asString();
        assertThat(output2, equalTo("|(x+y)|"));
    }

    @Test
    public void Square(){
        Variable x = new Variable("x",4.0);
        Variable y = new Variable("y",1.0);

        Formula formula = new Square(new Sum(x, y));
        double output = formula.asValue();
        assertThat(output, equalTo(25.0));

        String output2 = formula.asString();
        assertThat(output2, equalTo("(x+y)**2"));
    }

    @Test
    public void SquareRoot(){
        Variable x = new Variable("x",24.0);
        Variable y = new Variable("y",1.0);

        Formula formula = new SquareRoot(new Sum(x, y));
        double output = formula.asValue();
        assertThat(output, equalTo(5.0));

        String output2 = formula.asString();
        assertThat(output2, equalTo("(x+y)**0.5"));
    }

    @Test
    public void Power(){
        Variable x = new Variable("x",1.0);
        Variable y = new Variable("y",1.0);

        Formula formula = new Power(new Sum(x, y),5);
        double output = formula.asValue();
        assertThat(output, equalTo(32.0));

        String output2 = formula.asString();
        assertThat(output2, equalTo("(x+y)**5"));
    }

    @Test
    public void Minimum(){
        Variable x = new Variable("x",1.0);
        Variable y = new Variable("y",5.0);

        Formula formula = new Minimum(new Sum(x, y),new Sum(x,x,y),new Product(x,y));
        double output = formula.asValue();
        assertThat(output, equalTo(5.0));

        String output2 = formula.asString();
        assertThat(output2, equalTo("min((x+y),(x+x+y),(x*y))"));
    }

    @Test
    public void Maximum(){
        Variable x = new Variable("x",1.0);
        Variable y = new Variable("y",5.0);

        Formula formula = new Maximum(new Sum(x, y),new Sum(x,x,y),new Product(x,y));
        double output = formula.asValue();
        assertThat(output, equalTo(7.0));

        String output2 = formula.asString();
        assertThat(output2, equalTo("max((x+y),(x+x+y),(x*y))"));
    }

}
