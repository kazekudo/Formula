public class SquareRoot implements Formula{

    private Formula formula;
    public SquareRoot(Formula formula) {
        this.formula = formula;
    }

    @Override
    public String asString() {
        return formula.asString()+"**0.5";
    }

    @Override
    public double asValue() {
        return Math.sqrt(formula.asValue());
    }
}
