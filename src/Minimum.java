public class Minimum implements Formula{

    private Formula[] formula;
    public Minimum(Formula... formula) {
        this.formula = formula;
    }

    @Override
    public String asString() {
        String result = "min(";
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
        double minimum = formula[0].asValue();
        for(int i=1;i<formula.length;i++) {
            if(minimum>formula[i].asValue())
            minimum = formula[i].asValue();
        }
        return minimum;
    }
}
