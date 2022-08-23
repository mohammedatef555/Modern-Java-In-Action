package Chapter5.part6.myAnswers;

import Chapter5.part6.Trader;
import Chapter5.part6.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class QuestionThree {
    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.transactions;
        // Find all traders from Cambridge and sort them by name.
        List<Trader> tradersNames =
                transactions.stream()
                        .map(t -> t.getTrader())
                        .filter(t -> t.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(Collectors.toList());

        System.out.println(tradersNames);

    }
}
