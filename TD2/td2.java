abstract class Véhicule
{
    private Moteur moteurPrincipale ;
    private Carosserie c;
    private Roue[] listRoue = new Roue[4];

      public Moteur getMoteurPrincipale()
    {
        return moteurPrincipale;
    }

    public Carosserie getCarosserie()
    {
        return c;
    }

    public Roue[] getlistRoue()
    {
        return listRoue;
    }
    
}

class TypeA extends Véhicule
{
    // Autre méthodes (pas d'attribut normalement puisque elle sont toutes dans la classe mère "Véhicule").
}

class TypeB extends Véhicule
{
    private Moteur moteurSecondaire;
    private Roue roueSupplémentaire1;
    private Roue roueSupplémentaire2;

    public Roue getRoueSupplémentaire1()
    {
        return roueSupplémentaire1;
    }

    public Roue getRoueSupplémentaire2()
    {
        return roueSupplémentaire2;
    }

    public Moteur getMoteurSecondaire()
    {
        return moteurSecondaire;
    }
}

class Moteur
{
    // Attributs + Méthodes
}

class Roue
{
    // Attributs + Méthodes
}

class Carosserie
{
    private Porte[] listPortes = new Porte[4];

    public Porte[] getListPortes()
    {
        return listPortes;
    }
}

class Porte
{
    // Attributs + Méthodes
}
