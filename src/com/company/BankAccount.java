package com.company;

public class BankAccount {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public double deposit(double sum){

        amount = amount + sum;
        return amount;
    }
    public void withDraw(int sum){
        while (true) {
            if (amount < sum){

                try {
                    throw new LimitException("Запрашиваемая сумма на снятие больше чем остаток денег на счете:  " + amount, amount);
                } catch (LimitException limitException) {
                    System.out.println(limitException.getMessage());
                } finally {
                    withDraw((int) amount);
                }
            }
            if (amount >= sum) {
                amount = (int) (amount - sum);
                System.out.println(amount);
            }
            if (amount == (double) 0) {
                break;
            }
        }
    }
}
