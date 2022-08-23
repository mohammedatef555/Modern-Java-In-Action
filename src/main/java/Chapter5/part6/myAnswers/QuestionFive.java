package Chapter5.part6.myAnswers;

import Chapter5.part6.Transaction;

import java.util.List;

public class QuestionFive {
    public static void main(String[] args) {
        // Are any traders based in Milan?
        List<Transaction> transactions = Transaction.transactions;
        boolean isTheeAnyInMilan =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(isTheeAnyInMilan);
    }
}
