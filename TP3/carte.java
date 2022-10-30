import java.util.*;
import java.io.*;

class Carte
{
    public static enum Couleur {PIQUE,COEUR,CARREAU,TREFLE}
    private int valeur;
    private Couleur couleur;

    public Carte(int val,Couleur c)
    {
        this.valeur = val;
        this.couleur = c;
    }
    
    public int compare(Carte c)
    {
        return Integer.compare(valeur,c.getValeur());
    }

    public int getValeur()
    {
        return valeur;
    }

    public Couleur getCouleur()
    {
        return couleur;
    }

    @Override
    public String toString()
    {
        return String.format("%d de %s",valeur,couleur);
    }
}


class Paquet
{
    private ArrayList<Carte> paquet = new ArrayList<Carte>();
    
    @Override
    public String toString()
    {
        String resultat = "Contenu de votre paquet ::\n";
        for (int i = 0; i < this.getNombresCartes();i++)
            {
                resultat += String.format("[%d] :: %s\n",i,getCarte(i).toString());  
            }
        return resultat;
    }

    public void ajouterCarte(Carte carte)
    {
        paquet.add(carte);
    }

    public Carte retirerCarte(Carte carte)
    {
        paquet.remove(carte);
        return carte;
    }

    public Carte retirerCarte(int index)
    {
        Carte carte = paquet.get(index);
        paquet.remove(index);
        return carte;
    }
    
    public Carte getCarte(int index)
    {
        return paquet.get(index);
    }

    public int getNombresCartes()
    {
        return paquet.size();
    }
    
    public void melanger()
    {
        Random random = new Random();
        int a;
        int b;
        Carte tempo;
        for (int i = 0; i < this.getNombresCartes() *2;i++)
            {
                a = random.nextInt(this.getNombresCartes());
                b = random.nextInt(this.getNombresCartes());
                tempo = this.getCarte(a);
                paquet.set(a,this.getCarte(b));
                paquet.set(b,tempo);
            }
    }
}

abstract class Joueur
{
    private String nom;
    protected Paquet monPaquet = new Paquet();

    // public void nouveauJeu()
    //Je ne vois pas comment l'utiliser ou en quoi elle peut être avantageuse

    public Joueur(String nom)
    {
        this.nom = nom;
    }
    
    public  Carte jouer()
    {
        return choisirCarte();
    }
 
    public abstract Carte choisirCarte();
    
    public void recupererCarte(Carte c)
    {
        monPaquet.ajouterCarte(c);
    }

    public void perdreCarte(Carte c)
    {
        monPaquet.retirerCarte(c);
    }
    
    public Boolean aPerdu()
    {
        if (monPaquet.getNombresCartes() == 0)
            {
                return true;
            }
        return false;
    }

    @Override
    public String toString()
    {
        return String.format("Joueur %s avec un paquet de taille %d ",nom,monPaquet.getNombresCartes());
    }
}

class Ordinateur extends Joueur
{
    private Random random = new Random();

     public Ordinateur(String nom)
    {
        super(nom);
    }
    
    public Carte choisirCarte()
    {
        return super.monPaquet.getCarte(random.nextInt(super.monPaquet.getNombresCartes()));
    }
}

class Humain extends Joueur
{
    public Humain(String nom)
    {
        super(nom);
    }
    
    public Carte choisirCarte()
    {
        int choix = -1;
         System.out.println(super.monPaquet.toString());

        // Boucle infini;
        /*   Scanner input = new Scanner(System.in); 

        do
            {
                System.out.println("Indiquer l'index de la carte choisie.");
                if(input.hasNextInt())
                {
                choix = input.nextInt();
                }
                } while(choix == -1 || choix >= monPaquet.getNombresCartes());
        */

         do
             {
                 String mot = "null";
                 System.out.println("Indiquer l'index de la carte choisie.\n");
                 
                 try {Reader isr = new InputStreamReader(System.in) ;
                     BufferedReader br = new BufferedReader(isr) ;
                     mot = br.readLine();
                 }
                 catch (IOException e)
                     {
                         System.out.println("ERREUR PAS DE MOT");
                     }
                 try {
                     choix = Integer.parseInt(mot);
                 }
                 catch (NumberFormatException n)
                     {
                         System.out.println("\nCECI N'EST PAS UN INDEX VALIDE\n");
                     }
        
    
             } while(choix == -1 || choix >= monPaquet.getNombresCartes());
        
         return super.monPaquet.getCarte(choix);
                
    }
}
