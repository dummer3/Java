import java.util.*;

public class City
{
    // attributs et méthodes
}

class Capital extends City
{
    // attributs et méthodes
}

class Country
{
    private ArrayList<City> villes = new ArrayList<City>();
    
    // Réponse à la question 3 : En définissant une seule variable public
    // et en empêchant son changement (private + pas de méthodes pour la modifier)
    // Le mot-clé final va aussi empêcher son changement (sauf dans le constructeur)
    
    private final Capital capitale;

    public Country(Capital c)
    {
        capitale = c;
    }
    
    public void addCity(City c)
    {
        villes.add(c);
    }

    public boolean addCities(Enumeration<City> c)
    {
        return villes.addAll(Collections.list(c));

        // OU

        /*
          for (Enumeration<City> ville = c ; ville.hasMoreElements() ; )
            {
                addCity(ville.nextElement());
            }
        */


        
    }
}
