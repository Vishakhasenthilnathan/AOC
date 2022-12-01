import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/day1_input.txt");
        String s = "";
        int sumOfEachElvesCalories = 0, maxCaloriesByAnElf = 0;
        Scanner scan = new Scanner(inputFile);
//        //part1
//        while (scan.hasNext()) {
//            s = scan.nextLine();
//            if (!s.isEmpty()) {
//                sumOfEachElvesCalories = sumOfEachElvesCalories + Integer.valueOf(s);
//            } else {
//                maxCaloriesByAnElf = Math.max(maxCaloriesByAnElf, sumOfEachElvesCalories);
//                sumOfEachElvesCalories = 0;
//            }
//        }
//        System.out.println(sumOfEachElvesCalories);

        //part 2
        List<Integer> caloriesList = new ArrayList<>();
        while (scan.hasNext()) {
            s = scan.nextLine();
            if (!s.isEmpty()) {
                sumOfEachElvesCalories = sumOfEachElvesCalories + Integer.valueOf(s);
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
