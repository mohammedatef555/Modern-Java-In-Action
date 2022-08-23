package Chapter5.part6.myAnswers;

import Chapter5.part6.Transaction;

import java.util.List;

public class QuestionSix {
    public static void main(String[] args) {
        // Print the values of all transactions from the traders living in Cambridge.
        List<Transaction> transactions = Transaction.transactions;
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }
}
