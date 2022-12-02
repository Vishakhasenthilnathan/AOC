import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main() throws FileNotFoundException {
        File inputFile = new File("src/day1_input.txt");
        int sumOfEachElvesCalories = 0, maxCaloriesByAnElf = 0;
        Scanner scanner = new Scanner(inputFile);
        String s;

        //part1: find the max count
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            if (!s.isEmpty()) {
                sumOfEachElvesCalories += Integer.valueOf(s);
            } else {
                maxCaloriesByAnElf = Math.max(maxCaloriesByAnElf, sumOfEachElvesCalories);
                sumOfEachElvesCalories = 0;
            }
        }
        System.out.println(sumOfEachElvesCalories);

        //part 2: sum the top 3 counts
        sumOfEachElvesCalories = 0;
        scanner = new Scanner(inputFile);
        List<Integer> caloriesList = new ArrayList<>();

        while (scanner.hasNext()) {
            s = scanner.nextLine();
            if (!s.isEmpty()) {
                sumOfEachElvesCalories += Integer.valueOf(s);
            } else {
                caloriesList.add(sumOfEachElvesCalories);
                sumOfEachElvesCalories = 0;
            }
        }

        Collections.sort(caloriesList, Collections.reverseOrder());
        int sumOfTopThreeCalories = caloriesList.stream().limit(3).mapToInt(Integer::intValue).sum();
        System.out.println(sumOfTopThreeCalories);
    }

}
