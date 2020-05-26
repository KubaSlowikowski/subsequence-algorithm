package slowikowski;

import java.util.Scanner;

class Main {
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
                return true; // zwraca true jesli gwiazdka jest ostatnim elementem (poprzednie sa okej)
            }

            /*
             * Jesli wystapi gwiazdka traktowana doslownie (\*) wchodzimy do wewnetrznej petli for, jest ona podobna do tej wyzej,
             * Zostala ona uzyta, poniewaz kosztem kilku dodatkowych linijek, unikamy niepotrzebnego dodatkowego sprawdzania w if-ie w petli wyzej
             */
            if (subSequence.charAt(j) == '\\' && j + 1 < subLength && subSequence.charAt(j + 1) == '*') {
                for (int jj = j + 1; jj < subLength && i < seqLength; i++) {
                    if (subSequence.charAt(jj) == sequence.charAt(i)) {
                        j++;
                        jj++;
                    }
                }
                j++;
                break;
            }
            if (subSequence.charAt(j) == sequence.charAt(i)) {
                j++;
            }
        }

        return (j == subLength);
    }

    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pierwszy ciag: ");
        String str1 = scanner.nextLine();
        System.out.println("Podaj drugi ciag: ");
        String str2 = scanner.nextLine();

        if(main.isSubsequence(str1, str2)) {
            System.out.println("Drugi ciag znakow JEST podciagiem pierwszego.");
        } else {
            System.out.println("Drugi ciag znakow NIE JEST podciagiem pierwszego.");
        }
    }
}