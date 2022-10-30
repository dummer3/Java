import java.util.*;

public class Name {
    private final String first;
    private final String last;

    public Name(String first,String last)
    {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals (Object o)
    {
        if(o == this)
            {
                return true;
            }
        Name n = (Name) o;
        System.out.println("First ::: " + n.first.equals(first));
        System.out.println("Last ::: " + n.last.equals(last));
        return n.first.equals(first) &&  n.last.equals(last);
    }
    @Override
    public int hashCode ()
    {
        return Objects.hash(first,last);
    }

    public static void main(String[] args) {
        Set<Name> s = new HashSet<>();
        List<Name> l = new ArrayList<>();
        s.add(new Name("Arthur","Dent"));
        l.add(new Name("Arthur","Dent"));

        System.out.println(l.contains(new Name("Arthur","Dent")));
        System.out.println(s.contains(new Name("Arthur","Dent")));
     

    }
}
