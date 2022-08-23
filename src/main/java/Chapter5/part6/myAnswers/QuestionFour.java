package Chapter5.part6.myAnswers;

import Chapter5.part6.Trader;
import Chapter5.part6.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class QuestionFour {
    public static void main(String[] args) {
        // Return a string of all traders’ names sorted alphabetically.
        List<Transaction> transactions = Transaction.transactions;
        String traderNames =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .sorted(comparing(Trader::getName))
                        .map(Trader::getName)
                        .distinct()
                        .reduce("", (a, b) -> a + b + " ")
                        .toString();
        System.out.println(traderNames);

    }
}
