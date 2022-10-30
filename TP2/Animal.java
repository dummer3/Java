abstract class Animal
{
    private String nom;

    public Animal(String s)
    {
        this.nom = s;
    }
    
    public String toString()
    {
        return String.format("||Animal :: %s||",nom);
    }

    public String getNom()
    {
        return nom;
    }
}
