public class Dog extends Animal
{
    public Dog(String s)
    {
        super(s);
    }
    
    @Override
    public String toString()
    {
        return String.format("||Dog ::  %s||",getNom());
    }

    public void woof()
    {
        System.out.println("woof");
    }
}
