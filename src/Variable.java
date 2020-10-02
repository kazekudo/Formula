public class Variable implements Formula{

    private String string;
    private double val;
    public Variable(String string,double val){
        this.string=string;
        this.val=val;
    }

    public void set(double changeValeur) {
        this.val=changeValeur;
    }


    @Override
    public String asString() {
        return this.string;
    }

    @Override
    public double asValue() {
        return this.val;
    }


}
