public abstract class VariadicOperator implements Formula{

    private Formula[] formula;
    public VariadicOperator(Formula... formula) {
        this.formula = formula;
    }

    @Override
    public String asString() {
        String result="(";
        for(int i=0;i<formula.length;i++){
            result += formula[i].asString();
            if(i==formula.length-1)
                result += ")";
            else
                result += symbol();
        }
        return result;
    }

    @Override
    public double asValue() {
        double result=initialValue();
        for(int i=0;i<formula.length;i++){
            result = cumulativeValue(result,formula[i].asValue());
        }
        return result;
    }

    public abstract String symbol();
    public abstract double initialValue();
    public abstract double cumulativeValue(double accumulator,double value);

}
