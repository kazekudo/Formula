public class AbsoluteValue implements Formula{

    private Formula formula;
    public AbsoluteValue(Formula formula) {
        this.formula = formula;
    }

    @Override
    public String asString() {
        return "|"+formula.asString()+"|";
    }

    @Override
    public double asValue() {
        return Math.abs(formula.asValue());
    }
}
