import java.util.List;
import java.util.LinkedList;

class A {
    protected String name;
    public A(String n) {this.name = n;}
    public String name(){return "A:"+this.name;}
    public void bar(A a)
    {
        System.out.format("%s: A.bar(%s)\n",this.name(),a.name());  
    }
    
}
class B extends A {
  
    public B(String n) {super(n);}
    public String name(){return "B:"+this.name;}
    public void bar(B b)
    {
        System.out.format("%s: B.bar(%s)\n",this.name(),b.name());  
    }
    
}
class C {
  
    public void baz(A a)
    {
        System.out.format("C.baz(A : %s)\n",a.name());  
    }
        public void baz(B b)
    {
        System.out.format("C.baz(B : %s)\n",b.name());  
    }
    
}

class TestP{
    public static void main(String[] args) {
        A a =new A("a");
        B b = new B("b");
        A b2 = new B("b2");
        C c = new C();

        List<A> s = new LinkedList<A>();
        s.add(a);s.add(b);s.add(b2);
        for(A e :s)
            {
                for (A f: s)
                    {
                        e.bar(f);
                    }
                c.baz(e);
            }
    }
}
