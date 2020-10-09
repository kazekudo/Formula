public class Sum extends VariadicOperator{

    public Sum(Formula... formula) {
        super(formula);
    }


    public String symbol(){
        return "+";
    }

    public double initialValue(){
        return 0;
    }

    public double cumulativeValue(double accumulator,double value){
        return accumulator+value;
    }
}
