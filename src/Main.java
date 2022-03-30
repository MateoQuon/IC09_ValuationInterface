import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Collection of CommonStocks and Bonds
        List<Security> portfolio = new ArrayList<>();
        portfolio.add(new CommonStock("1234567", "Apple, Inc.", 100, 100.0, 134.89));
        portfolio.add(new Bond("7654321", "Govt. 2 Year", 10000, 1.13, 2.0));

        System.out.println("Before Sort: ");
        for (Security s: portfolio)
            System.out.println(s);

        Collections.sort(portfolio);

        System.out.println("After Sort: ");
        for (Security s: portfolio)
            System.out.println(s);

    }
}
