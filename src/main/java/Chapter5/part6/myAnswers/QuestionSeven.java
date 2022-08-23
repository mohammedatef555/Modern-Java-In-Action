package Chapter5.part6.myAnswers;

import Chapter5.part6.Transaction;

import java.util.List;
import java.util.Optional;

public class QuestionSeven {
    public static void main(String[] args) {
        //What’s the highest value of all the transactions?
        List<Transaction> transactions = Transaction.transactions;
        Optional<Integer> max =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);
        max.ifPresent(System.out::println);
    }
}
