package decorator.factory.calculator;

import java.util.Scanner;

public class CalculatorView {
    private final ICalculableFactory calculableFactory;

    public CalculatorView(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void choice(){
        System.out.println("Выберите, пожалуйста тип калькулятора:\n1 - простые числа \n2 - комплексные числа");
        int kind = promptInt("Введите число: ");
        if (kind == 1) run();
        else if (kind == 2) runCmplx();
        else System.out.println("Неверный ввод");
    }

    public void run() {
        while (true) {
            int primaryArg = promptInt("Введите первый аргумент: ");
            Calculable calculator = calculableFactory.create(primaryArg);
            while (true) {
                String cmd = prompt("Введите команду (*, +, =) : ");
                if (cmd.equals("*")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    int arg = promptInt("Введите второй аргумент: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    int result = calculator.getResult();
                    System.out.printf("Результат %d\n", result);
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    public void runCmplx(){
        while (true) {
        int primaryReal = promptInt("Введите реальную часть 1го комплексного числа: ");
        int primaryImage = promptInt("Введите мнимую часть 1го комплексного числа: ");
        Complex complex1 = new Complex(primaryReal, primaryImage);
        int secondReal = promptInt("Введите реальную часть 2го комплексного числа: ");
        int secondImage = promptInt("Введите мнимую часть 2го комплексного числа: ");
        Complex complex2 = new Complex(secondReal, secondImage);
        Calculable calculator = calculableFactory.create(complex1, complex2);
        while (true) {
            String cmd = prompt("Введите команду (+, *, /) : ");
            if (cmd.equals("+")) {
                calculator.sumCmplx(complex1, complex2);
            }
            if (cmd.equals("*")) {
                calculator.multiCmplx(complex1, complex2);
            }
            if (cmd.equals("/")) {
                calculator.divCmplx(complex1, complex2);
            }

            Complex result = calculator.getResultComplex();
            System.out.println(result.toString());
            break;
            }

            String cmdYN = prompt("Еще посчитать (Y/N)?");
            if (cmdYN.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
