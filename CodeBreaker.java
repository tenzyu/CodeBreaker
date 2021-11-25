import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;


public class CodeBreaker {

    private final Scanner scanner;
    private final int MAX_NUMBER;  // must be less than 10
    private final int CODE_LENGTH; // must be less than MAX_NUMBER
    private int tryCount;
    private int playCount = 0;

    public CodeBreaker() {
        this(7, 3);
    }

    public CodeBreaker(int maxNumber, int codeLength) {
        scanner = new Scanner(System.in);
        MAX_NUMBER = maxNumber;
        CODE_LENGTH = codeLength;
    }

    void newGame() {
        tryCount = 0;
        playCount++;
        List<Integer> correctAnswer = newCorrectAnswer();

        guessAnswer(correctAnswer);

        if (playerWannaContinue()) {
            newGame();
        }

        System.out.println("See you next time.");
    }

    private List<Integer> newCorrectAnswer() {
        IntStream integerStream = IntStream.range(0, MAX_NUMBER + 1);
        List<Integer> integerList = streamToIntegerList(integerStream);
        shuffle(integerList);
        return integerList.subList(0, CODE_LENGTH);
    }

    private List<Integer> streamToIntegerList(IntStream stream) {
        return stream.boxed().collect(toList());
    }

    private void guessAnswer(List<Integer> correctAnswer) {
        tryCount++;
        System.out.print("What's your guess? ");
        List<Integer> playerGuess = getPlayerGuess();

        if (correctAnswer.equals(playerGuess)) {
            showWinResults();
            return;
        }

        showHints(correctAnswer, playerGuess);
        guessAnswer(correctAnswer);
    }

    private List<Integer> getPlayerGuess() {
        String playerInput = scanner.next();

        if (isValidInput(playerInput)) {
            return inputToIntegerList(playerInput);
        }

        return getPlayerGuess();
    }

    private boolean isValidInput(String input) {
        if (!input.matches("[0-9]+")) {
            System.out.print("Not a numeric number. ");
            return false;
        }
        if (CODE_LENGTH != input.length()) {
            System.out.print("Wrong number of digits. ");
            return false;
        }
        return true;
    }

    private List<Integer> inputToIntegerList(String input) {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            integerList.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        return integerList;
    }

    private void showWinResults() {
        System.out.println("You Win!");
        System.out.println("You tried " + tryCount + " time(s).");
        System.out.println("And you played the game " + playCount + " time(s).");
    }

    private void showHints(List<Integer> correctAnswer, List<Integer> playerGuess) {
        int hit = 0, blow = 0;

        for (int i = 0; i < CODE_LENGTH; i++) {
            for (int j = 0; j < CODE_LENGTH; j++) {
                if (!correctAnswer.get(i).equals(playerGuess.get(j))) {
                    continue;
                }
                if (i == j) {
                    hit++;
                } else {
                    blow++;
                }
            }
        }

        System.out.println(hit + " HIT, " + blow + " BLOW");
    }

    private boolean playerWannaContinue() {
        System.out.print("Do you wanna continue? (y / n): ");
        String input = scanner.next();

        if (input.equals("y") || input.equals("n")) {
            return input.equals("y");
        }

        System.out.print("Please enter y or n: ");
        return playerWannaContinue();
    }
}
