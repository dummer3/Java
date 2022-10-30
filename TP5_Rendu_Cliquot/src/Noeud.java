import java.util.HashMap;

// Représente tout les élements possible dans notre équation.
public abstract class Noeud
{
    @Override
    public String toString()
    {
        return getValeur().toString();
    }

    /** 
     * Permet d'obtenir la valeur de ce Noeud.
     * @return un Object (Double ou String).
     */
    public abstract  Object getValeur();

    /**
     * L'opération de ce Noeud
     * Possible que pour NoeudOperation est ses enfants, sinon jette un UnsupporetedOperationException().
     * @param l est la valeur à gauche de l'opérante et r celle de droite.
     * @return le résultat de cette opération.
     */
    public abstract Double operation(Double l,Double r);

    /**
     * Résout une équation.
     * @param h un HashMap<String,Double> correspondant au couple (nomVariable, valeurVariable).
     * @return le résultat de l'évalutation de ce Noeud (en Double).
     */
    public abstract Double eval(HashMap<String,Double> h);

    /**
     * Transforme une expression sous forme préfixe en un Arbre.
     * @param s est la chaîne de caractère à transformer.
     * @return un Noeud représentant l'expression de ce Noeud.
     */
    public static Noeud fromPrefixe(String s)
    {
        if(s.length() > 0 && s.charAt(0) == '(')
            {
                // Notre String représente une opération.
                String gauche;
                String droite;
                int parentheseFermante;
                int parentheseOuvrante;
                
                if(s.length() > 3 && s.charAt(3) == '(')
                    {
                        // L'élément gauche est une oération.
                        parentheseFermante = Noeud.findIndexParentheseFermante(s,3);
                        gauche = s.substring(3,parentheseFermante);
                    }
                else
                    {
                        // Sinon c'est une constante ou une variable.
                        parentheseFermante = s.indexOf(" ",3);
                        gauche = s.substring(3,parentheseFermante);
                    }
               
                if(s.length() > parentheseFermante + 1 && s.charAt(parentheseFermante+1) == '(')
                    {
                        // L'élément droit est une opération.
                        int fin = Noeud.findIndexParentheseFermante(s,parentheseFermante+1);
                        droite = s.substring(parentheseFermante+1,fin);
                    }
                else
                    {
                        // Sinon c'est une constante ou une variable.
                        int fin = s.indexOf(")",parentheseFermante+1);
                        droite = s.substring(parentheseFermante +1,fin);
                    }
                // On retourne l'opération.
                return NoeudOperation.fromPrefixe(s.substring(1,2),gauche,droite);  
            }
        else
            {
                // Sinon c'est une constante ou une variable.
                if(isNumeric(s))
                    {
                        // C'est une constante.
                        return NoeudConstante.fromPrefixe(s);
                    }
                else
                    {
                        // Sinon c'est une variable.
                        return NoeudVariable.fromPrefixe(s);
                    }           
            }
    }

    // Nous dit si notre String peut être transformer en un nombre.
    private static boolean isNumeric(String string) {
        Double value;
        if(string == null || string.equals(""))
            {
                return false;
            }
        try
            {
                value = Double.parseDouble(string);
                return true;
            } catch (NumberFormatException e){}
        return false;
    }

    // Nous donne la parenthèse fermante correspondant à la parenthèse ouvrante d'index "indexStart".
    private static int findIndexParentheseFermante(String s, int indexStart) {

        int indexOuv;
        int indexFerm;
        int index = indexStart+1;
        int nbr = 1;
        
        while (nbr != 0 &&  index < s.length())
            {
                indexOuv = s.indexOf('(',index);
                indexFerm = s.indexOf(')',index);
                if(indexOuv < indexFerm && indexOuv != -1)
                    {
                        nbr++;
                        index = indexOuv+1;
                    }
                else
                    {
                        nbr--;
                        index = indexFerm+1;
                    }               
            }
        return index--;
    }
}
