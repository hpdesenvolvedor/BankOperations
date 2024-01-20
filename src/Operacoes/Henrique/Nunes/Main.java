package Operacoes.Henrique.Nunes;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank santander = new Bank("4252");
        //C = criar uma conta.
        //E = sair da conta (exit)
        while (true) {
            System.out.println("O que deeja fazer? C=criar conta, E=Sair da conta");

            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite o seu nome:");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);
                operateAccount(account);


            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido! Tente novamente.");
            }
        }
        List<Account> accountList = santander.getAccounts();
        for (Account cc: accountList){
            System.out.println(cc);
        }

        santander.outputTotal();


        // D = Deposito
        // S = Saque
        // E = Sair (exit)
    }
        static void operateAccount(Account account){

        Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("O que deseja fazer? D=Deposito, S=Saque, E=Sair da Conta");
                String op = scanner.nextLine();

                if (op.equals("D")){
                    System.out.println("Qual o valor que deseja depositar? ");
                    double value = scanner.nextDouble();
                    account.deposit(value);

                } else if (op.equals("S")) {
                    System.out.println("Qual valor deseja sacar?");
                    double value = scanner.nextDouble();
                    if (account.sacar(value)) {
                        System.out.println("Não foi possível sacar o valor" + value);

                    }
                } else if (op.equals("E")) {
                    break;
                } else {
                    System.out.println("Comando inválido! Tente novamente.");
                }

                scanner = new Scanner(System.in);
            }
        }
}