public class Power implements Formula {

    private Formula formula;
    int p;
    public Power(Formula formula,int p) {
        this.formula = formula;
        this.p=p;
    }

    @Override
    public String asString() {
        return formula.asString()+"**"+String.valueOf(p);
    }

    @Override
    public double asValue() {
        double result = formula.asValue();
        for(int i=1;i<p;i++)
            result *= formula.asValue();
        return result;
    }
}
