package decorator.factory.calculator;

public class Complex {
    double real;
    double img;

    public Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public double getReal() {
        return real;
    }

    public double getImg() {
        return img;
    }

    @Override
    public String toString() {
        String tmp;
        if(img > 0){
            tmp = real + " + " + img + "i";
        }else if(img < 0){
            tmp = real + " " + img + "i";
        }else{
            tmp = String.valueOf(real);
        }

        return tmp;
    }
}
