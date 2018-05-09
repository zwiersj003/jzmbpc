import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    private static int[] array;
    private static final int SIZE = 20;
    private static final int MAX = 20;

    public static void main(String[] args) {

        //bucketsort werkt
        System.out.println("Bucketsort");
        createRandomArray();
        bucketsort(array);

        //pigeonholesort werkt
        System.out.println();
        System.out.println("Pigeonhole sort");
        createRandomArray();
        pigeonholesort(array);

        //kmp
        System.out.println();
        System.out.println("Knutt-Morris-Pratt");
        Tekst tekst = new Tekst();
        //testen knuth-morris-pratt
        System.out.println("Test knuth-morris-pratt");

        Tabel zomer = tekst.searchKMP("zomer");
        System.out.println("\t knuth-morris-pratt \t zomer \t\t\t aantal: "
                + zomer.getTeller() + "\t vergelijkingen: " + zomer.getVergelijkingen());
        Tabel en = tekst.searchKMP("en");
        System.out.println("\t knuth-morris-pratt \t en \t\t\t aantal: "
                + en.getTeller() + "\t vergelijkingen: " + en.getVergelijkingen());
        Tabel tweelingsterren = tekst.searchKMP("tweelingsterren");
        System.out.println("\t knuth-morris-pratt \t tweelingsterren \t aantal: "
                + tweelingsterren.getTeller() + "\t vergelijkingen: " + tweelingsterren.getVergelijkingen());
        Tabel fietsen = tekst.searchKMP("fietsen");
        System.out.println("\t knuth-morris-pratt \t fietsen \t\t aantal: "
                + fietsen.getTeller() + "\t vergelijkingen: " + fietsen.getVergelijkingen());
        Tabel Geluid = tekst.searchKMP("Geluid");
        System.out.println("\t knuth-morris-pratt \t Geluid \t\t aantal: "
                + Geluid.getTeller() + "\t vergelijkingen: " + Geluid.getVergelijkingen());
        Tabel Plotseling = tekst.searchKMP("Plotseling");
        System.out.println("\t knuth-morris-pratt \t Plotseling \t\t aantal: "
                + Plotseling.getTeller() + "\t vergelijkingen: " + Plotseling.getVergelijkingen());
        Tabel meisjes = tekst.searchKMP("meisjes");
        System.out.println("\t knuth-morris-pratt \t meisjes \t\t aantal: "
                + meisjes.getTeller() + "\t vergelijkingen: " + meisjes.getVergelijkingen());
        Tabel boerinnen = tekst.searchKMP("boerinnen");
        System.out.println("\t knuth-morris-pratt \t boerinnen \t\t aantal: "
                + boerinnen.getTeller() + "\t vergelijkingen: " + boerinnen.getVergelijkingen());
        Tabel waarom = tekst.searchKMP("waarom");
        System.out.println("\t knuth-morris-pratt \t waarom \t\t aantal: "
                + waarom.getTeller() + "\t vergelijkingen: " + waarom.getVergelijkingen());
        Tabel Mei = tekst.searchKMP("Mei");
        System.out.println("\t knuth-morris-pratt \t Mei \t\t\t aantal: "
                + Mei.getTeller() + "\t vergelijkingen: " + Mei.getVergelijkingen());
    }

    public static void createRandomArray(){
        array = new int[SIZE];
        for (int i = 0; i < SIZE; i++){
            int j = (int)(Math.random() * MAX);
            array[i] = j;
        }
    }

    public static void bucketsort(int[] array) {
        for(Integer i : array){
            System.out.print(i + ", ");
        }
        double begin = System.nanoTime();

        int amountofbuckets = 2;

        // add buckets
        LinkedList[] bucket = new LinkedList[amountofbuckets];
        for (int i = 0; i < amountofbuckets; i++) {
            bucket[i] = new LinkedList<Integer>();
        }

        //loop array and put in buckets
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 10)
                index = 0;
            else
                index = 1;
            bucket[index].add(array[i]);
        }
        //sort every bucket
        for (int i = 0; i < amountofbuckets; i++) {
            Collections.sort(bucket[i]);
        }

        //buckets to array
        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                array[index] = (Integer) bucket[i].get(j);
                index++;
            }
        }

        double eind = System.nanoTime();
        //Verschil in tijd geconverteerd naar seconden
        System.out.println();
        System.out.println("Tijd(sec):  " + (eind - begin) / 1000000000);
        for(Integer i : array){
            System.out.print(i + ", ");
        }
    }

    public static void pigeonholesort(int[] array)
    {
        for (Integer i : array){
            System.out.print(i + ", ");
        }
        double begin = System.nanoTime();

        // size of range of values in the list (ie, number of pigeonholes we need)
        int min = array[0], max = array[0];
        for (int x : array) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        final int size = max - min + 1;

        // our array of pigeonholes
        int[] holes = new int[size];

        // Populate the pigeonholes.
        for (int x : array)
            holes[x - min]++;

        // Put the elements back into the array in order.
        int i = 0;
        for (int count = 0; count < size; count++)
            while (holes[count]-- > 0)
                array[i++] = count + min;

        double eind = System.nanoTime();
        //Verschil in tijd geconverteerd naar seconden
        System.out.println();
        System.out.println("Tijd(sec):  " + (eind - begin) / 1000000000);
        for (Integer j : array){
            System.out.print(j + ", ");
        }
    }
}
