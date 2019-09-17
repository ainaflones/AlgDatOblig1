import junit.framework.TestCase;

import java.util.Arrays;

public class Oblig1TestEgen extends TestCase {

    public void testMaks() {

        int[] a = {1,4,7,5,3,6};

        //Testing to see if the highest value is correct
        assertEquals(7,Oblig1.maks(a));

        //Checks what value is last
        System.out.println(a[a.length-1]);

    }

    public void testOmbyttinger() {


        int[] a={1,6,4,10,33,63,32};
        int[] b= {1,4,7,5,3,6};
        int[] c ={33,57,21,45,68};

        assertEquals(2,Oblig1.ombyttinger(a));
        assertEquals(3,Oblig1.ombyttinger(b));
        assertEquals(2,Oblig1.ombyttinger(c));


    }

    public void testSjekkSortering() {

        int[] c ={33,57,21,45,68};

        assertEquals(false,Oblig1.sjekkSortering(c));

    }

    public void testAntallUlikeSorter() {

        int[] a = {1,1,1,2,4,5,7,7,7};

        assertEquals(5,Oblig1.antallUlikeSortert(a));
    }

    public void testAntallulikeUsortert() {

        int[] a= {1,5,3,2,4,1222,1,3,5};

        assertEquals(6,Oblig1.antallUlikeUsortert(a));

    }

    public void testDelsortering() {

        int[] a= {6,10,9,4,1,3,8,5,2,7};

        Oblig1.delsortering(a);
        for(int b: a){
            System.out.println(b);
        }




    }

    public void testRotasjon() {
        char[] a = {};
        char[] b = {'A'};
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        Oblig1.rotasjon(a);
        assertEquals("[]", Arrays.toString(a));

        Oblig1.rotasjon(b);
        assertEquals("[A]", Arrays.toString(b));

        Oblig1.rotasjon(c);
        assertEquals("[J, A, B, C, D, E, F, G, H, I, J]", Arrays.toString(c));
    }

    public void testRotasjon1() {
        char[] a = {};
        char[] b = {'A'};
        char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        Oblig1.rotasjon(a, 2);
        assertEquals("[]", Arrays.toString(a));

        Oblig1.rotasjon(b, -4);
        assertEquals("[A]", Arrays.toString(b));

        Oblig1.rotasjon(c, 3);
        assertEquals("[H, I, J, A, B, C, D, E, F, G]", Arrays.toString(c));

        Oblig1.rotasjon(c, -2);
        assertEquals("[J, A, B, C, D, E, F, G, H, I]", Arrays.toString(c));

        Oblig1.rotasjon(c, -12);
        assertEquals("[B, C, D, E, F, G, H, I, J, A]", Arrays.toString(c));
    }

    public void testFlett() {

        String a = Oblig1.flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        System.out.println(a);
    }
}