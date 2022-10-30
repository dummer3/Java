public class exo1
{
    public static void main(String[] args)
    {
        Dog medor = new Dog("Medor") ;
        Animal felix = new Cat("Felix") ;

        System.out.println(medor.toString());
        System.out.println(felix.toString());

        medor.woof();
        ((Cat) felix).meow();
        //((Cat) medor).meow(); IMPOSSIBLE
    }
}
