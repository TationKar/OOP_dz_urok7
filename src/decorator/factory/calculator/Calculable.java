package decorator.factory.calculator;

public interface Calculable {
    Calculable sum(int arg);
    Calculable multi(int arg);
    int getResult();
    Calculable sumCmplx(Complex complex1, Complex complex2);
    Calculable multiCmplx(Complex complex1, Complex complex2);
    Calculable divCmplx(Complex complex1, Complex complex2);
    Complex getResultComplex();
}
