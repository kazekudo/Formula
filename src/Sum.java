public class Sum implements Formula{

    private Formula[] formula;
    public Sum(Formula... formula) {
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
                result += "+";
        }
        return result;
    }

    @Override
    public double asValue() {
        double result=0;
        for(int i=0;i<formula.length;i++){
            result += formula[i].asValue();
        }
        return result;
    }
}
