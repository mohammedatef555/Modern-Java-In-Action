package Chapter5.part6.myAnswers;

import Chapter5.part6.Transaction;

import java.util.List;
import java.util.Optional;

public class QuestionEight {
    public static void main(String[] args) {
        //Find the transaction with the smallest value.
        List<Transaction> transactions = Transaction.transactions;
        Optional<Integer> min =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::min);
        min.ifPresent(System.out::println);
    }
}
