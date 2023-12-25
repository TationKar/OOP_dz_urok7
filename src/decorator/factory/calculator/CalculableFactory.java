package decorator.factory.calculator;

public class CalculableFactory implements ICalculableFactory {
    public Calculable create(int primaryArg) {
        return new Calculator(primaryArg);
    }

    @Override
    public Calculable create(Complex cmplxFrst, Complex cmplScnd) {
        return new Calculator(cmplxFrst, cmplScnd);
    }
}
