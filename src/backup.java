//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//import static java.util.stream.Collectors.toList;
//import static java.util.stream.IntStream.range;
//
//public class codebreaker.CodeBreaker {
//    // setting
//    static final int MAX_NUMBER = 7; // but smaller than 9
//    static final int CODE_LENGTH = 3; // but smaller than MAX_NUMBER
//
//    static int tryCount = 0;
//    static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        var answer = createAnswer();
//
//        tryCount++;
//        var userAnswer = getUserAnswer();
//
//        if (answer.equals(userAnswer)) {
//            System.out.println("You Win!");
//            System.out.println("You Tried " + tryCount + " times.");
//            return;
//        }
//        int hit = 0, blow = 0;
//
//        for (int i = 0; i < CODE_LENGTH; i++)
//            for (int j = 0; j < CODE_LENGTH; j++) {
//                if (answer.get(i).equals(userAnswer.get(j))) {
//                    if (i == j) hit++;
//                    if (i != j) blow++;
//                }
//            }
//        System.out.println(hit + " hit, " + blow + " blow");
//    }
//
//    private static List<Integer> getUserAnswer() {
//        // userInput: 234
//        // userAnswer -> [4, 3, 2]
//        // return [2, 3, 4]
//        int userInput = sc.nextInt();
//        List<Integer> userAnswer = new ArrayList<>();
//        for (int i = 0; i < CODE_LENGTH; i++) {
//            userAnswer.add(userInput % 10);
//            userInput /= 10;
//        }
//        Collections.reverse(userAnswer);
//        return userAnswer;
//    }
//
//    private static List<Integer> createAnswer() {
//        var stream = range(0, MAX_NUMBER + 1);
//        List<Integer> zeroToSeven = stream.boxed().collect(toList());
////        Collections.shuffle(zeroToSeven);
//        return zeroToSeven.subList(0, CODE_LENGTH);
//    }
//}
