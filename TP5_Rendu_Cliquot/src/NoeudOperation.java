import java.util.HashMap;

// Correspond à tous les noeud opération possible
public abstract class NoeudOperation extends Noeud
{
    private String val;
    private Noeud noeudGauche;
    private Noeud noeudDroit;

    public NoeudOperation(String val)
    {
        super();
        this.val = val;
        noeudGauche = null;
        noeudDroit = null;
    }

    @Override
    public String toString()
    {
        return String.format("(%s %s %s)",noeudGauche.toString(),super.toString(),noeudDroit.toString());
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
     * Résout une équation.
     * @see Noeud.eval().
     */
    @Override
    public Double eval(HashMap<String,Double> h)
    {
        Double d = operation(this.noeudGauche.eval(h),this.noeudDroit.eval(h));
        System.out.println(String.format("OPERATION (%s) ::: %f",getValeur(),d));
        return d;
    }

    /**
     * Transforme une expression sous forme préfixe en un Arbre
     * @param op est la valeur de cette racine, l la préfixe du sous arbreGauche et r la préfixe du sousAbreDroit.
     * @see Noeud.fromPrefixe().
     */
    public static Noeud fromPrefixe(String op,String l,String r)
    {

        NoeudOperation n = NoeudOperation.creerNoeudOperation(op);
        n.noeudGauche = Noeud.fromPrefixe(l);
        n.noeudDroit = Noeud.fromPrefixe(r);

        return n;
    }

    /**
     * Renvoie la bonne sous classe de NoeudOperation en fonction du String Donnée.
     * @param un string (+,-,* ou /).
     * @return Un NoeudOperation correspondant à la valeur donné en paramètre. 
     */
    public static NoeudOperation creerNoeudOperation(String s)
    {
        NoeudOperation n;
        switch (s)
            {
            case "+" :  n = new NoeudAddition(); break;
            case "-" :  n = new NoeudSoustraction(); break;
            case "*" :  n = new NoeudProduit(); break;
            case "/" :  n = new NoeudDivision(); break;
            default : throw new IllegalArgumentException("Nom de variable non défini pour les opérations");
            }
        return n;
    }

}

// Représente l'addition.
class NoeudAddition extends NoeudOperation
{
    public NoeudAddition()
    {
        super("+");
    }

     /**
     * Effectue l'opération addition
     * @see Noeud.operation().
     */
    @Override
    public Double operation(Double l,Double r)
    {
        return l+r;
    }
}

// Représente la soustraction.
class NoeudSoustraction extends NoeudOperation
{
    public NoeudSoustraction()
    {
        super("-");
    }
    
    /**
     * Effectue l'opération soustraction
     * @see Noeud.operation().
     */
    @Override
    public Double operation(Double l,Double r)
    {
        return l-r;
    }
}

// Représente la division
class NoeudDivision extends NoeudOperation
{
    public NoeudDivision()
    {
        super("/");
    }

    /**
     * Effectue l'opération division
     * @see Noeud.operation().
     */
    @Override
    public Double operation(Double l,Double r)
    {
        return l/r;
    }
}

// Représente le produit.
class NoeudProduit extends NoeudOperation
{
    public NoeudProduit()
    {
        super("*");
    }

    /**
     * Effectue l'opération produit
     * @see Noeud.operation().
     */
    @Override
    public Double operation(Double l,Double r)
    {
        return l*r;
    }
}
