public class Square implements Formula{

    private Formula formula;
    public Square(Formula formula) {
        this.formula = formula;
    }


    @Override
    public String asString() {
        return formula.asString()+"**2";
    }

    @Override
    public double asValue() {
        return formula.asValue()*formula.asValue();
    }
}
