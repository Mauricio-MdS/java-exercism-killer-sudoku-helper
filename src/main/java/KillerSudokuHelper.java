import java.util.ArrayList;
import java.util.List;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (cageSize == 1) {
            if (!exclude.contains(cageSum)) combinations.add(new ArrayList<>(List.of(cageSum)));
            return combinations;
        }

        for (int i = 1; i < 9 && i < cageSum; i++) {
            if (exclude.contains(i)) continue;
            List<Integer> newExcluded = new ArrayList<>(exclude);
            newExcluded.add(i);
            final int firstElement = i;
            var otherElements = combinationsInCage(cageSum - i, cageSize - 1, newExcluded);
            otherElements.forEach(l -> {
                if (!l.isEmpty()) {
                    l.add(firstElement);
                    l.sort(Integer::compareTo);
                    if (!combinations.contains(l)) combinations.add(l);
                }
            });
        }
        return combinations;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, new ArrayList<>());
    }

}
