// av Aina Flønes(S305075) og Wei-Ting Kao(334005)

import java.util.NoSuchElementException;

public class Oblig1 {


    /**
     *OPPGAVE 1
     *
     * Antall sammenligninger i denne metoden(som en funksjon av n) er n-1.
     *
     * The highest amount of switching occurs when the array is sorted in descending order, because every number has to switch places.
     * The lowest amount of switching occurs when the array is sorted in ascending order, where none of the numbers has to be switched.
     * TODO: What is the average?
     * TODO: Kan vi på grunnlag av dette si noe om metoden maks er bedre eller dårligere enn de vi har sett på tidligere?
     *
     *
     * @param a
     * @return
     */


    public static int maks(int[] a) {

        if(a.length <= 0){
            throw new NoSuchElementException("The array is empty");
        }

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i] > a[i + 1]) {

                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;

            }
        }

        return a[a.length - 1];
    }

    public static int ombyttinger(int a[]){

        int count = 0;

        for (int i = 0; i < a.length - 1; i++) {

            if (a[i] > a[i + 1]) {
                count++;
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;

            }
        }

        return count;
    }


    /**
     * Oppgave 2
     * Made a method to check if the array is sorted in descending order.
     *
     */

    public static int antallUlikeSorter(int[] a){

        if(!sjekkSortering(a)){
            throw new IllegalStateException("Array not sorted");
        }

        if(a.length == 0){
            return 0;
        }

        int count = 1;

        for(int i = 0; i < a.length-1; i++){

            if(a[i] != a[i+1]){
                count++;
            }
        }

        return count;
    }


    public static boolean sjekkSortering(int[] a){

        boolean sjekk  = true;

        for(int i = 0; i<a.length-1; i++){

            if (a[i] > a[i+1]){
                sjekk = false;
            }
        }
        return sjekk;
    }

    /**
     * Opppgave 3
     *
     *TODO: ?????
     *
     */

    public static int antallulikeUsortert(int [] a){

        if(a.length == 0){
            return 0;
        }
        int count = 0;

        int test = maks(a);


        for(int i = 0; i <= test; i++){

            for (int j = 0; j < a.length; j++) {

                if (a[j] == i) {
                    count++;
                    break;
                }
            }

        }
        return count;
    }

    /**
     * OPPGAVE 4
     */
    
    public static void delsortering(int[] a) {


        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            while (left < right && a[left] % 2 != 0) left++;
            while (left < right && a[right] % 2 == 0) right--;

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }

        sort(a, 0, right);
        sort(a, right, a.length);
    }

    public static void sort(int[] a, int from, int to) {

        for (int i = from; i < to - 1; i++) {

            int x = i;
            int verdi = a[i];

            for (int j = i + 1; j < to; j++) {

                if (a[j] < verdi) {
                    verdi = a[j];
                    x = j;
                }
            }

            int temp = a[i];
            a[i] = a[x];
            a[x] = temp;
        }
    }


    /**
     * Oppgave 5
     * @param a
     */

    public static void rotasjon(char[] a) {
        if (a.length <= 1) return;

        char temp = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            a[i + 1] = a[i];
        }

        a[0] = temp;
    }

    /**
     * Oppgave 6
     * @param a
     * @param k
     */
    public static void rotasjon(char[] a, int k) {
        if (a.length <= 1) return;

        k = k % a.length; // remove unnecessary rotations
        if (k == 0) return;

        if (k < 0) { // turn all k positive and all rotation rightwards
            k += a.length;
        }

        char[] temp = new char[k];  // temporary storage

        int marker = a.length - k;  // marks the start of values to be copied
        for (int i = 0; i < temp.length; i++, marker++) { // copy to temp storage
            temp[i] = a[marker];
        }

        // move the rest of the values k steps to the right, starting from the end

        for (int i = a.length - 1; i >= k; i--) {
            a[i] = a[i - k];
        }

        for (int i = 0; i < temp.length; i++) { // place the temp values back to the array
            a[i] = temp[i];
        }
    }

    public static String flett(String a, String b) {

        String flettet = "";

        int counterA = 0;
        int counterB = 0;

        while (counterA != a.length() || counterB != b.length()) {
            if (counterA < a.length()) {
                flettet += a.charAt(counterA++);
            }
            if (counterB < b.length()) {
                flettet += b.charAt(counterB++);
            }
        }
        return flettet;

    }

    /**
     * Oppgave 7B
     * @param s
     * @return
     */
    public static String flett(String... s) {

        String flettet = "";

        int counter = 0;
        int biggest = s[0].length();

        do{

            for (String a : s) {
                if (a.isEmpty() || a.length() <= counter) {
                } else
                    flettet += a.charAt(counter);
                if(a.length()>biggest) biggest = a.length();
            }
            counter++;
        }
        while(counter<biggest);

        return flettet;

    }

}