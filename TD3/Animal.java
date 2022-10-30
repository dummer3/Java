import java.util.*;

interface I_Animal
{
    public abstract String courir();
    public abstract String crier();
}

interface I_Vehicule
{
    public static int MIN_CAPACITE = 1;
    
    public abstract void entrer(Personne p);
    public abstract void sortir(Personne p);
    public abstract Boolean estOccupe();
    public abstract String Avancer();
        
}

class Personne <A extends I_Animal,B extends I_Vehicule>
{
    ArrayList<A> animals = new ArrayList<A>();
    ArrayList<B> véhicules = new ArrayList<B>();
    // attributs et méthodes
}

class Moto implements I_Vehicule
{
    private int capacite = 2;
    private Personne[] personneDansVéhicule = new Personne[capacite];
    
    public void entrer(Personne p)
    {
        // Do stuff
    }

    public void sortir(Personne p)
    {
        // Do stuff
    }

    public Boolean estOccupe()
    {
        // Do stuff
        return false;
    }
    
    public String Avancer()
    {
        return "J'avance en moto";
    }
}

class Cheval implements I_Vehicule,I_Animal
{
    private int capacite = 1;
    private Personne[] personneDansVéhicule = new Personne[capacite];

    public String courir()
    {
        return "Je galope";
    }

    public String crier()
    {
        return "Je hennis";
    }
    
    public void entrer(Personne p)
    {
        // Do stuff
    }

    public void sortir(Personne p)
    {
        // Do stuff
    }

    public  Boolean estOccupe()
    {
        // Do stuff
        return false;
    }
    
    public String Avancer()
    {
        return "J'avance à cheval";
    }
    
}
