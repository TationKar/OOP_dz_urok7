package decorator.factory.calculator;

public interface ICalculableFactory {
    Calculable create(int primaryArg);
    Calculable create(Complex cmplxFrst, Complex cmplScnd);
}
