import org.junit.Test;

public class FormulaMain {

    public static void generatePoints(Formula formula,Variable variable,double startValue,double endValue, double step){
        variable.set(startValue);
        while(variable.asValue()<=endValue){
            System.out.print(variable.asValue()+" "+formula.asValue()+"\n");
            variable.set(variable.asValue()+step);
        }
    }

    @Test
    public void Main(){
        Variable x = new Variable("x",0.0);
        Formula formula = new Square(x);
        generatePoints(formula, x,-5,10,1.5);
    }
}
