import junit.framework.TestCase;

public class Oblig1Test extends TestCase {

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

        assertEquals(5,Oblig1.antallUlikeSorter(a));
    }
}