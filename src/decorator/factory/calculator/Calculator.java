package decorator.factory.calculator;

public final class Calculator implements Calculable {

    private int primaryArg;
    private Complex firstCmplx;
    private Complex secondCmplx;
    private Complex resultCmplx;

    public Calculator(int primaryArg) {
        this.primaryArg = primaryArg;
    }

    public Calculator(Complex firstCmplx, Complex secondCmplx){
        this.firstCmplx = firstCmplx;
        this.secondCmplx = secondCmplx;
    }

    @Override
    public Calculable sum(int arg) {
        primaryArg += arg;
        return this;
    }

    @Override
    public Calculable multi(int arg) {
        primaryArg *= arg;
        return this;
    }

    @Override
    public int getResult() {
        return primaryArg;
    }


    @Override
    public Calculable sumCmplx(Complex complex1, Complex complex2) {
        double real1 = complex1.getReal();
        double image1 = complex1.getImg();
        double real2 = complex2.getReal();
        double image2 = complex2.getImg();
        double newReal = real1 + real2;
        double newImage = image1 + image2;
        resultCmplx = new Complex(newReal,newImage);
        return this;
    }

    @Override
    public Calculable multiCmplx(Complex complex1, Complex complex2) {
        double real1 = complex1.getReal();
        double image1 = complex1.getImg();
        double real2 = complex2.getReal();
        double image2 = complex2.getImg();
        double newReal = real1*real2 - image1*image2;
        double newImage = image1*real2 + real1*image2;
        resultCmplx = new Complex(newReal,newImage);
        return this;
    }

    @Override
    public Calculable divCmplx(Complex complex1, Complex complex2) {
        double real1 = complex1.getReal();
        double image1 = complex1.getImg();
        double real2 = complex2.getReal();
        double image2 = complex2.getImg();
        double newReal = (real1*real2 + image1*image2)/(real2*real2 + image2*image2);
        double newImage = (image1*real2 - real1*image2)/(real2*real2 + image2*image2);
        resultCmplx = new Complex(newReal,newImage);
        return this;
    }

    @Override
    public Complex getResultComplex() {
        return resultCmplx;
    }
}