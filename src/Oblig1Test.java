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

    public void testAntallulikeUsortert() {

        int[] a= {1,5,3,2,4,1222,1,3,5};

        assertEquals(6,Oblig1.antallulikeUsortert(a));

    }

    public void testDelsortering() {

        int[] a= {6,10,9,4,1,3,8,5,2,7};

        Oblig1.delsortering(a);
        for(int b: a){
            System.out.println(b);
        }




    }
}