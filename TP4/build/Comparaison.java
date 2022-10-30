import java.util.*;
import java.lang.System.*;

public class Comparaison
{
    public static void main(String[] args) {
        Etudiant[] e = new Etudiant[100];
        ArrayList<Etudiant> a = new ArrayList<Etudiant>();
        HashMap h = new HashMap<Etudiant,Etudiant>();

        long timeAvant = System.nanoTime();

        
        for(int n = 0; n < 100_000; n++)
            {
                for (int i = 0; i <100; i++)
                    {
                        e[i] = new Etudiant(i,20);
                    }
            }
        System.out.printf("|||%f|||\n",(double)(System.nanoTime()-timeAvant));
        timeAvant = System.nanoTime();
        for(int n = 0; n < 100_000; n++)
            {
                for (int i = 0; i <100; i++)
                    {
                        a.add(new Etudiant(i,20));
                    }
            }
            System.out.printf("|||%f|||\n",(double)(System.nanoTime()-timeAvant));
            timeAvant = System.nanoTime();
                for(int n = 0; n < 100_000; n++)
            {
                for (int i = 0; i <100; i++)
                    {
                        h.put(new Etudiant (i,20),new Etudiant (i,20));
                    }
            }
                System.out.printf("|||%f|||\n",(double)(System.nanoTime()-timeAvant));
    }
}

class Etudiant
{
    int numEtu;
    int note;

    public Etudiant(int a,int b)
    {
        this.numEtu = a;
        this.note = b;
    }
    
}
