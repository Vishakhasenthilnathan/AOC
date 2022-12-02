import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main() throws FileNotFoundException {
        File inputFile = new File("src/day2_input.txt");
        Scanner scanner = new Scanner(inputFile);
        String s="";
        int sum =0, totalPoints =0;
        while(scanner.hasNext()){
            s = scanner.nextLine();
            String[] move = s.split(" ");
            String oppMove = move[0];
            String endResult = move[1];
            String ourMove = findOurMove(oppMove,endResult);
            sum = findWinnerPoints(oppMove,ourMove) + ourMovePoints(ourMove);
            totalPoints += sum;
        }
        System.out.println(totalPoints);
    }

    private static String findOurMove(String oppMove, String endResult) {
        //u need to lose
        if(endResult.equals("X")){
            if(oppMove.equals("A"))
                return "Z";
            else if(oppMove.equals("B"))
                return "X";
            else
                return "Y";
        }//u need to draw
        else if(endResult.equals("Y")){
            if(oppMove.equals("A"))
                return "X";
            else if(oppMove.equals("B"))
                return "Y";
            else
                return "Z";
        }//u need to win
        else {
            if(oppMove.equals("A"))
                return "Y";
            else if(oppMove.equals("B"))
                return "Z";
            else
                return "X";
        }
    }

    private static int ourMovePoints(String ourMove) {
        int points=0;
        switch (ourMove){
            case "X" : points = 1; break;
            case "Y" : points = 2; break;
            case "Z" : points = 3;break;
        }
        return points;
    }

    private static int findWinnerPoints(String oppMove, String ourMove) {
        int points;
        if((oppMove.equals("A") && ourMove.equals("X")) || (oppMove.equals("B") && ourMove.equals("Y")) || (oppMove.equals("C") && ourMove.equals("Z"))){
            points =3;
        }
        else if((oppMove.equals("A") && ourMove.equals("Z")) || (oppMove.equals("B") && ourMove.equals("X")) || (oppMove.equals("C") && ourMove.equals("Y"))){
            points =0;
        }else{
            points = 6;
        }
        return points;
    }
}
