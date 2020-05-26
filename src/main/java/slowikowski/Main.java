package slowikowski;


import java.util.Scanner;

class Main {

    private String firstSequence;
    private String secondSequence;

    private void readData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pierwszy ciag: ");
        firstSequence = scanner.nextLine();
        System.out.println("Podaj drugi ciag: ");
        secondSequence = scanner.nextLine();
    }

    boolean isSubsequence(String sequence, String subSequence) {
        int seqLength = sequence.length();
        int subLength = subSequence.length();
        int j = 0;

        for (int i = 0; i < seqLength && j < subLength; i++) {

            /*
             * Jesli wystapi gwiazdka, sprawdzany jest ciag znakow po niej
             */
            if (subSequence.charAt(j) == '*') {
                for (int jj = j + 1; jj < subLength && i < seqLength; i++) {
                    if (subSequence.charAt(jj) == sequence.charAt(i)) {
                        j++;
                        jj++;
                    }
                    break;
                }
            }

            if (subSequence.charAt(j) == '\\' && j + 1 < subLength && subSequence.charAt(j + 1) == '*') {
                subLength--;
                j++;
            } else if (subSequence.charAt(j) == sequence.charAt(i)) {
                j++;
            }
        }

        return (j == subLength);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.readData();
        System.out.println(main.isSubsequence(main.firstSequence, main.secondSequence));
    }
}






