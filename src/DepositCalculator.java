import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double year, int day) {
        double pay = amount * Math.pow((1 + year / 12), 12 * day);
        return roundAmount(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return roundAmount(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double roundAmount(double amount, int period) {
        double scale = Math.pow(10, period);
        return Math.round(amount * scale) / scale;
    }

    void calculateDeposit() {
        int period, action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDoubleVar = 0;
        if (action == 1)
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
