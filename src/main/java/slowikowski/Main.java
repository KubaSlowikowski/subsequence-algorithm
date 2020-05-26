package slowikowski;

import java.util.Scanner;

class Main {
    boolean isSubsequence(String sequence, String subSequence) {
        int seqLength = sequence.length();
        int subLength = subSequence.length();
        /*
         * j - suma kontrolna. Ilosc liter z drugiego ciagu (subSequence), ktora wystepuje w pierwszym ciagu.
         * WARUNEK KONIECZNY:
         * suma kontrolna rowna sie dlugosc badanego podciagu
         */
        int j = 0;
        boolean b = true;

        for (int i = 0; i < seqLength && j < subLength; i++) {
            /*
             * jesli drugi ciag posiada '\*',
             * wchodzimy do ponizszego if-a, i sprawdzamy czy pierwszy ciag posiada symbol '*'
             */
            if (!b) {
                boolean found = false;
                for (; i < seqLength; i++) {
                    if (subSequence.charAt(j) == sequence.charAt(i)) {
                        found = true;
                        b = !b;
                        j++;
                        break;
                    }
                }
                if (!found) {
                    break;
                } else {
                    continue;
                }
            }
            /*
             * Jesli w drugim ciagu wystapi '*', sprawdzane sa litery po niej
             */
            if (subSequence.charAt(j) == '*' && b) {
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
             * Jesli wystapi gwiazdka traktowana doslownie (\*) wchodzimy do wnetrza if-a
             */
            if (subSequence.charAt(j) == '\\' && j + 1 < subLength && subSequence.charAt(j + 1) == '*') {
                j++;
                b = false; //oznacza, ze przy kolejnej iteracji symbol '*' bez traktowany doslownie
                i--;
            } else if (subSequence.charAt(j) == sequence.charAt(i)) {
                j++;
            }
        }

        if (j == subLength)
            return true;
        else if (subLength > seqLength && subSequence.charAt(j) == '*') { // <-- zabezpieczenie przed podciagiem konczacym sie na '*'
            j++;
            return (j == subLength);
        }
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pierwszy ciag: ");
        String str1 = scanner.nextLine();
        System.out.println("Podaj drugi ciag: ");
        String str2 = scanner.nextLine();

        if (main.isSubsequence(str1, str2)) {
            System.out.println("Drugi ciag znakow JEST podciagiem pierwszego.");
        } else {
            System.out.println("Drugi ciag znakow NIE JEST podciagiem pierwszego.");
        }
    }
}