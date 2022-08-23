package Chapter5.part6.myAnswers;

import Chapter5.part6.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class QuestionOne {
    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.transactions;
        // Find all transactions in the year 2011 and sort them by value (small to high) ?
        List<Transaction> transactionList =
                transactions.stream()
                        .filter(t -> t.getYear() == 2011)
                        .sorted(comparing(Transaction::getValue))
                        .collect(Collectors.toList());
        System.out.println(transactionList);

    }
}
