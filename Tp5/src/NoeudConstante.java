import java.util.HashMap;


// Représente les constantes
public class NoeudConstante extends Noeud
{
    double val;

       public NoeudConstante(double v)
    {
        super();
        this.val = v;
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
        Double d = (Double) getValeur();
        System.out.println(String.format("CONSTANTE ::: %f",d));
        return d;
    }

    /**
     * Transforme une expression sous forme préfixe en un Arbre
     * @see Noeud.fromPrefixe().
     */
    public static Noeud fromPrefixe(String s)
    {
        return new NoeudConstante(Double.parseDouble(s));
    }
}
