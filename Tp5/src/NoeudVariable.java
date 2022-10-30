import java.util.HashMap;

// Représente les variables.
public class NoeudVariable extends Noeud
{
    String val;

    public NoeudVariable(String v)
    {
        super();
        this.val = verifVariable(v);
    }
    
    /** 
     * Permet d'obtenir la valeur de ce Noeud.
     * @see Noeud.getValeur().
     */
    public Object getValeur()
    {
        return val;
    }
   
    /**
     * La méthode opération ne doit pas être appelé dans NoeudConstante.
     * @see Noeud.operation().
     */
    public Double operation(Double l,Double r)
    {
        throw new UnsupportedOperationException();   
    }

  

    /**
     * Résout une équation.
     * @see Noeud.eval().
     */
    @Override
    public Double eval(HashMap<String,Double> h)
    {
        Double d = h.get(getValeur());
        if(d != null)
            {
                System.out.println(d);
                System.out.println(String.format("VARIABLE (%s) ::: %f",getValeur(),d));
            }
        else
            {
                throw new IllegalArgumentException("\nAucune variable avec ce nom trouvé\nPour l'ajouter faite bien nom_variable=valeur (sans espace)");
            }
        return d;
    }
    
      /**
     * Transforme une expression sous forme préfixe en un Arbre
     * @see Noeud.fromPrefixe().
     */
    public static Noeud fromPrefixe(String s)
    {
        return new NoeudVariable(s);
    }
    
    // Vérifie si notre nom de variable ne risque pas d'être confondue avec un opérateur.
    private static String verifVariable(String v)
    {
        if(v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/") || v.equals("="))
            {
                throw new IllegalArgumentException("Nom de variable défini pour les opérations");
            }
        return v;
    }
    
}

