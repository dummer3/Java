import java.io.*;

public class exo2
{
    public static void main(String args[])
    {
        String mot = null ;
        try {Reader isr = new InputStreamReader(System.in) ;
            BufferedReader br = new BufferedReader(isr) ;
            mot = br.readLine() ;
        }
        catch (IOException e)
            {
                System.out.println("ERREUR PAS DE MOT");
            }
        
        Mot m = new Mot(mot);
        Mot m1 = new Mot("onj");
        System.out.println(m.toString());
        m.afficheVoyelles();
        System.out.println(m.estPalindrome());
        System.out.println(m.estContenu(m1));
        m.trie();
    }
}
