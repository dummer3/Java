import java.util.HashMap;
import java.io.*;

public class testArbre
{
    public static void main(String[] args) {

        // Un exemple
        
        HashMap<String,Double> h = new HashMap<String,Double>();
        
        h.put("epsilon",Double.valueOf(3));
        h.put("sigma",Double.valueOf(2));
        h.put("tho",Double.valueOf(1));
   
        Noeud b = Noeud.fromPrefixe("(/ (+ (* (- 2.3 4,33) tho) (/ epsilon (- sigma 4,5))) 2)");
        
        System.out.println("\n" + b.toString() + "\n");

        System.out.println(b.eval(h));


        // L'utilisateur peut rentre sa propre expression.
        
        System.out.println("\nEntrer votre expression sous forme préfixe.\n");
        String mot = null ;
        try {
            Reader isr = new InputStreamReader(System.in) ;
            BufferedReader br = new BufferedReader(isr) ;
            mot = br.readLine() ;
        }
        catch (IOException e) {
        }
    
        Noeud a = Noeud.fromPrefixe(mot);

        while(!mot.equals("stop"))
            {
                System.out.println("entrer une nouvelle variable (stop pour arrêter)\nexemple : x=6");
                try {
                    Reader isr = new InputStreamReader(System.in) ;
                    BufferedReader br = new BufferedReader(isr) ;
                    mot = br.readLine() ;
                }
                catch (IOException e) {
                }
                int index = mot.indexOf('=');
                if(index != -1)
                    {
                        mot = mot.replace(',','.');
                        h.put(mot.substring(0,index),Double.parseDouble(mot.substring(index+1)));   
                    }
            }

        System.out.println("\n" + a.toString() + "\n");
        System.out.println(a.eval(h));
    }
}
