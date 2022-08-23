package Chapter5.part6.myAnswers;

import Chapter5.part6.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionTwo {
    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.transactions;
        //What are all the unique cities where the traders work?
        List<String> citiesList =
                transactions.stream()
                        .map(t -> t.getTrader().getCity())
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println(citiesList);
    }
}
