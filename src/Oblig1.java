// av Aina Flønes(S305075), Wei-Ting Kao(334005) og Wai Shing Hung (s331376)

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    /**
     *OPPGAVE 1
     *
     * Antall sammenligninger i denne metoden(som en funksjon av n) er n-1.
     *
     * The highest amount of switching occurs when the array is sorted in descending order, because every number has to switch places.
     * The lowest amount of switching occurs when the array is sorted in ascending order, where none of the numbers has to be switched.
     * The average number of swaping = 1/2 + 2/3 + 3/4 + ... + (n-1)/n, where n is the amount of numbers
     *                               = (1 + 1 + 1 + ... + 1) - (1/2 + 1/3 + 1/4 + .... + 1/n)
     *                               = n - H_n, where H_n is the n-th harmonic number
     *                               = n - ln(n) - γ, where γ is the Euler constant
     *                               ~= n - ln(n) - 0.577
     *
     * Since n = 10, the average number of swaping = 1/2 + 2/3 + 3/4 + ... + 9/10 (~= 7.071 <= without using the euler constant approximation)
     *                                             ~= 10 - ln(10) -0.577
     *                                             ~= 7.12
     *
     *
     * In the previous max method, the average number of a[i] > max_value ~= ln(n) - 0.577, of order ln(n)
     * And the average number of a[i] > a[i+1] ~= n - ln(n) -0.577, of order n
     * Therefore the previous max method is better than the maks method here
     *
     *
     *
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

    public static int antallUlikeSortert(int[] a){

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
     **
     */

    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) return 0;
        if (a.length == 1) return 1;

        int count = 1;
        int first = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] != first) count++;
        }

        int start;
        for (int i = 1; i < a.length; i++) {
            start = a[i];
            if (start == a[i - 1]) continue;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == start) count--;
            }
        }
        return count;
    }

    /**
     * OPPGAVE 4
     */

    public static void delsortering(int[] a) {
        int left = 0;
        int right = a.length-1;

        if(a.length == 0){
          right = 0;
        }

        while (left < right) {
            while (left < right && a[left] % 2 != 0) left++;
            while (left < right && a[right] % 2 == 0) right--;

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
            else{
                if(left==a.length-1){
                    Arrays.sort(a);
                }
            }
        }

        if(right != -1){
            quickSort(a, 0, right-1);
            quickSort(a, right, a.length-1);
        }

    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int k = partition(a, left, right, (left + right) / 2);

        quickSort(a, left, k - 1);
        quickSort(a, k + 1, right);
    }

    private static int partition(int[] a, int left, int right, int indeks) {
        swap(a, indeks, right);

        int pos = partition0(a, left, right - 1, a[right]);
        swap(a, pos, right);
        return pos;
    }

    private static int partition0(int[] a, int left, int right, int pivot) {
        while (true)
        {
            while (left <= right && a[left] < pivot) left++;
            while (left <= right && a[right] >= pivot) right--;

            if (left < right) swap(a, left++, right--);
            else return left;
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * Oppgave 5
     *
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
     *
     *
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

    /**
     * Oppgave 7A
     *
     *
     *
     */

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
     *
     *
     */
    public static String flett(String... s) {

        String flettet = "";

        int counter = 0;
        int biggest = 0;


        if(s.length <= 1){
            return flettet;
        }
        else{
             biggest = s[0].length();
        }

        do{

            for (String a : s) {
                if (a.length() <= counter) {
                } else
                    flettet += a.charAt(counter);
                if(a.length()>biggest) biggest = a.length();
            }
            counter++;
        }
        while(counter<biggest);

        return flettet;

    }

    /**
    * Oppgave 8
    *
    *
    *
     **/

    public static int[] indekssortering(int[] a) {
        if (a == null) {
            throw new NoSuchElementException("List is empty");
        }

        int n = a.length;

        // copy input array such that it would not be changed in sorting
        int[] copy = new int[n];
        System.arraycopy(a, 0, copy, 0, n);

        // create a array of index having the same length as the copied array
        // indexList = {0, 1, 2, 3, ..., n-1}
        int[] indexList = new int[n];
        for (int i = 0; i < n; i++) {
            indexList[i] = i;
        }

        // Use selection sort theory to sort the copied array
        // at the same time change the position of indexList at the same time
        for (int i = 0; i < n - 1; i++) {
            int min = min(copy, i, n);
            exchange(copy, i, min);
            exchange(indexList, i, min);
        }

        return indexList;
    }

    public static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int min(int[] a, int from, int to) {
        if (from < 0 || to > a.length || from >= to)
            throw new IllegalArgumentException("Illegal interval!");

        int m = from;
        int min = a[from];

        for (int i = from + 1; i < to; i++)
            if (a[i] < min) {
                m = i;
                min = a[m];
            }

        return m;
    }


    /**
    * Oppgave 9
    * **/

    public static int[] tredjeMin(int[] list){
        int length = list.length;

        if (length < 3) {
            throw new NoSuchElementException("The array have fewer than 3 elements");
        }

        // use indekssortering to sort and find the correct start index and values of min, secondMin and thirdMin
        int[] copy = new int[3];
        System.arraycopy(list, 0, copy, 0, 3);
        int[] sortedFirstThree = indekssortering(copy);


        int min = sortedFirstThree[0];
        int secondMin = sortedFirstThree[1];
        int thirdMin = sortedFirstThree[2];

        int minValue = list[min];
        int secondMinValue = list[secondMin];
        int thirdMinValue = list[thirdMin];

        for (int i = 3; i < length; i++) {
            int value = list[i];

            if (value < thirdMinValue){
                if (value < secondMinValue){
                    // a[i] <minValue
                    if (value < minValue){
                        thirdMin = secondMin;
                        thirdMinValue = secondMinValue;
                        secondMin = min;
                        secondMinValue = minValue;
                        min = i;
                        minValue = value;
                    }
                    // minValue < a[i] < secondMinValue
                    else {
                        thirdMin = secondMin;
                        thirdMinValue = secondMinValue;
                        secondMin = i;
                        secondMinValue = value;
                    }
                }
                // secondMinValue < a[i] < thirdMinvalue
                else {
                    thirdMin = i;
                    thirdMinValue = value;
                }
            }
        }
        return new int[] {min, secondMin, thirdMin};

    }

    /**
     * oppgave 10
     * Vi tar som gitt at tegnstrengene ​a ​ og ​b​ kun har store bokstaver (A − Å)
     **/

    public static boolean inneholdt(String a, String b) {
        if (a.length() == 0) return true;
        if (a.length() > b.length()) return false;

        char[] aList = a.toCharArray();
        char[] bList = b.toCharArray();

        mergeSort(aList);
        mergeSort(bList);

        int aIndex = 0;
        int bIndex = 0;

        while(aIndex < aList.length && bIndex < bList.length){
            if(aList[aIndex] == bList[bIndex]){
                aIndex++;
                bIndex++;
            }
            else if (aList[aIndex] > bList[bIndex]){
                bIndex++;
            }
            else {
                return false;
            }
        }

        if(aIndex == aList.length){
            return true;
        }
        else {
            return false;
        }

    }

    private static void mergeSort(char[] a, char[] b, int from, int to) {
        if (to - from <= 1) return;
        int m = (from + to) / 2;

        mergeSort(a, b, from, m);
        mergeSort(a, b, m, to);

        if (a[m-1] > a[m]) merge(a, b, from, m, to);
    }

    public static void mergeSort(char[] a) {
        char[] b = new char[a.length / 2];
        mergeSort(a, b, 0, a.length);
    }

    private static void merge(char[] a, char[] b, int from, int m, int to) {
        int n = m - from;
        System.arraycopy(a, from, b, 0, n);

        int i = 0, j = m, k = from;

        while (i < n && j < to) {
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
        }

        while (i < n) a[k++] = b[i++];
    }
}