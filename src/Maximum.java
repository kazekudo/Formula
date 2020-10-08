public class Maximum implements Formula{

    private Formula[] formula;
    public Maximum(Formula... formula) {
        this.formula = formula;
    }

    @Override
    public String asString() {
        String result = "max(";
        for(int i=0;i<formula.length;i++){
            result += formula[i].asString();
            if(i==formula.length-1)
                result += ")";
            else
                result += ",";
        }
        return result;
    }

    @Override
    public double asValue() {
        double maximum = formula[0].asValue();
        for(int i=1;i<formula.length;i++) {
            if(maximum<formula[i].asValue())
                maximum = formula[i].asValue();
        }
        return maximum;
    }
}
