public class Product extends VariadicOperator{

    public Product(Formula... formula) {
        super(formula);
    }

    public String symbol(){
        return "*";
    }

    public double initialValue(){
        return 1;
    }

    public double cumulativeValue(double accumulator,double value){
        return accumulator*value;
    }
}
