
public class Cat  extends Animal
{
    public Cat(String s)
    {
        super(s);
    }
    
    @Override
    public String toString()
    {
        return String.format("||Cat ::  %s||",getNom());
    }

    public void meow()
    {
        System.out.println("meow");
    }
}

